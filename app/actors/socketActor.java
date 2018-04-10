package actors;

import akka.actor.*;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import twitter4j.*;
import twitter4j.Status;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static services.twitterService.getTwitterinstance;

public class socketActor extends AbstractActor {
    public static Props props(ActorRef out) {
        return Props.create(socketActor.class, out);
    }

    private final ActorRef out;
    private final Twitter twitter = getTwitterinstance();

    public socketActor(ActorRef out) {
        this.out = out;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    Runnable task = new Runnable() {
                            @Override
                            public void run() {
                                Query query = new Query(message);
                                query.setCount(10);
                                QueryResult result = null;
                                try {
                                    result = twitter.search(query);
                                } catch (TwitterException e) {
                                    e.printStackTrace();
                                }
                                List<Status> tweets = result.getTweets();
                                ArrayNode tweetJSON = Json.newArray();
                                tweets.forEach((tweet) -> {
                                    ObjectNode node = Json.newObject();
                                    node.put("text", tweet.getText());
                                    node.put("name", tweet.getUser().getName());
                                    node.put("screenName", tweet.getUser().getScreenName());
                                    node.put("message", message);
                                    tweetJSON.add(node);
                                });
                                out.tell(tweetJSON.toString(), self()) ;
                            }
                        };
                        ScheduledExecutorService service = Executors
                            .newSingleThreadScheduledExecutor();
                        service.scheduleAtFixedRate(task, 0, 10, TimeUnit.SECONDS);
                    }
                )
                .build();
    }
}

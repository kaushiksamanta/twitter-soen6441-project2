package actors;

import akka.actor.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Json;
import twitter4j.*;
import twitter4j.Status;
import static services.twitterService.getTwitterStreamFactory;

public class twitterActor extends AbstractActor {
    public static Props props(ActorRef out) {
        return Props.create(twitterActor.class, out);
    }

    private final ActorRef out;
    private final TwitterStream stream = getTwitterStreamFactory();

    public twitterActor(ActorRef out) {
        this.out = out;
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, message -> {
                    StatusListener listener = new StatusListener() {
                        @Override
                        public void onStatus(Status status) {
                            ObjectNode node = Json.newObject();
                            node.put("text", status.getText());
                            node.put("name", status.getUser().getName());
                            node.put("screenName", status.getUser().getScreenName());
                            out.tell(node.toString(), self()) ;
                        }

                        @Override
                        public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

                        }

                        @Override
                        public void onTrackLimitationNotice(int numberOfLimitedStatuses) {

                        }

                        @Override
                        public void onScrubGeo(long userId, long upToStatusId) {

                        }

                        @Override
                        public void onStallWarning(StallWarning warning) {

                        }

                        @Override
                        public void onException(Exception ex) {
                            ex.printStackTrace();
                        }
                    };

                    stream.addListener(listener);

                    // Filter
                    FilterQuery filter = new FilterQuery();
                    String[] keywordsArray = { message };
                    filter.track(keywordsArray);
                    filter.language(new String[]{"en"});
                    stream.filter(filter);

                    }
                )
                .build();
    }
}

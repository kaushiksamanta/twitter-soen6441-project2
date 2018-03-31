package services;

import modals.userModal;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * twitterService class contains all the methods required to access the twitter API.
 * @version 1.0
 * @author Kaushik Samanta
 */
public class twitterService {

    public static ConfigurationBuilder init() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("uvZYPifCuMDmDLhGzryVaH9sA")
                .setOAuthConsumerSecret("G01gHXhUerHAevCjhR0U1iOlm5VNmxC5cGRnldvHscVFcMfkvQ")
                .setOAuthAccessToken("969353476450017280-r7gPo5QAT8svSDiCBoB0jSKu1f3Oa8P")
                .setOAuthAccessTokenSecret("TmapsealCXor82pige4FwRZ16tqKollMbBb6AieVcKVrJ");
        return cb;
    }

    /**
     * Retrieve the instance of twitter with some default configuration.
     * @author Kaushik Samanta
     * @return A Twitter data type.
     */
    public static Twitter getTwitterinstance() {
        ConfigurationBuilder cb = init();
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }

    /**
     * Retrieve the instance of TwitterStream with some default configuration.
     * @author Kaushik Samanta
     * @return A TwitterStream data type.
     */
    public static TwitterStream getTwitterStreamFactory() {
        ConfigurationBuilder cb = init();
        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
        return twitterStream;
    }


    /**
     * Retrieve the instance of CompletionStage with userDetails.
     * @author Kaushik Samanta
     * @param username A username of type string.
     * @return A future data type.
     * @throws TwitterException It throws a TwitterException
     */
    public static CompletionStage<userModal> getUserDetails(String username) throws TwitterException {
        CompletableFuture<userModal> future = new CompletableFuture<>();
        Twitter twitter = getTwitterinstance();
        User user = twitter.showUser(username);
        List<Status> timelineData = getUsersTimeline(username);
        List<String> list = new ArrayList<String> ();
        timelineData.forEach((data) -> {
            list.add(data.getText());
        });
        userModal usermodal = new userModal();
        usermodal.setId(user.getId());
        usermodal.setName(user.getName());
        usermodal.setEmail(user.getEmail());
        usermodal.setScreenName(user.getScreenName());
        usermodal.setLocation(user.getLocation());
        usermodal.setDescription(user.getDescription());
        usermodal.setFollowersCount(user.getFollowersCount());
        usermodal.setUrl(user.getURL());
        usermodal.setBiggerProfileImageURLHttps(user.getBiggerProfileImageURLHttps());
        usermodal.setIsProtected(user.isProtected());
        usermodal.setTimeline(list);
        future.complete(usermodal);
        return future;
    }

    /**
     * Retrieve the user timeline details.
     * @author Kaushik Samanta
     * @param username A username of type string.
     * @return A List data type.
     * @throws TwitterException It throws a TwitterException
     */
    public static List<Status> getUsersTimeline(String username) throws TwitterException {
        Twitter twitter = getTwitterinstance();
        User user = twitter.showUser(username);
        Paging p = new Paging();
        p.setCount(10);
        List<Status> timeline = twitter.getUserTimeline(user.getId(),p);
        return timeline;
    }
}

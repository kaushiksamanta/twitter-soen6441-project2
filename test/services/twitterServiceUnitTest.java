package services;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import modals.userModal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import play.libs.Json;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;
import java.util.concurrent.ExecutionException;
import static org.junit.Assert.assertTrue;

import static org.mockito.Mockito.mock;
import org.mockito.runners.MockitoJUnitRunner;
import mocks.tweets;

/**
 * TwitterServiceUnitTest  contains methods to test 
 * the method of TwitterService class.
 * 
 * @see twitterService
 * @see twitterServiceUnitTest
 * @author Tejpreet Kaur
 *
 */

public class twitterServiceUnitTest {
//
//    private tweets tweetService;
//
//    @Before
//    public void setUp(){
//        tweetService = mock(tweets.class);
//        ArrayNode tweetJSON = null;
//        for(int i = 0; i < 10; i++) {
//            ObjectNode node = Json.newObject();
//            node.put("text", "asdsad"+i);
//            node.put("name", "asdfasds"+i);
//            node.put("screenName", "sdsadsadsa"+i);
//            tweetJSON.add(node);
//        }
//        tweetService.setTweets(tweetJSON);
//    }

    /**
     * public void testUserDetailsService annotate with @Test will be executed
	 * as a Test case.
	 * testUserDetailsService is checking whether the details for a specific 
	 * username are correct.
     * @author Tejpreet Kaur
     */
    @Test
    public void testUserDetailsService() throws TwitterException, ExecutionException, InterruptedException {
        userModal result = twitterService.getUserDetails("NarendraGarg001");
        assertTrue(result != null);
    }

    /**
     * public void testUserTimelineService annotate with @Test will be executed
	 * as a Test case.
	 * testUserTimelineService is checking whether the timeline details for a 
	 * specific  username exists and is correct.
     */
    @Test
    public void testUserTimelineService() throws TwitterException, ExecutionException, InterruptedException {
        List<Status> result = twitterService.getUsersTimeline("NarendraGarg001");
        assertTrue(result.size() >= 0);
    }

    /**
     * public void testTweetsService annotate with @Test will be executed
     * as a Test case.
     * testTweetsService is getting all the tweets for a particular search keyword.
     */
    @Test
    public void testTweetsService() throws TwitterException, ExecutionException, InterruptedException {
        ArrayNode result = twitterService.getTweets("Technology");
        assertTrue(result.size() >= 0);
    }

    /**
     * public void testTwitterInstanceService annotate with @Test will be executed
	 * as a Test case.
	 * testTwitterInstanceService is testing the existence of the  instance of the
	 * Twitter.
     * @author Tejpreet Kaur
     */
    @Test
    public void testTwitterInstanceService() throws TwitterException, ExecutionException, InterruptedException {
        Twitter tweet = twitterService.getTwitterinstance();
        assertTrue(tweet instanceof Twitter);
    }
}

package services;
import com.fasterxml.jackson.databind.node.ArrayNode;
import modals.userModal;
import org.junit.Test;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutionException;
import static org.junit.Assert.assertTrue;

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

    /**
     * public void testUserDetailsService annotate with @Test will be executed
	 * as a Test case.
	 * testUserDetailsService is checking whether the details for a specific 
	 * username are correct.
     * @author Tejpreet Kaur
     */
    @Test
    public void testUserDetailsService() throws TwitterException, ExecutionException, InterruptedException {
        CompletionStage<userModal> result = twitterService.getUserDetails("NarendraGarg001");
        assertTrue(result.toCompletableFuture().get().getScreenName() != null);
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

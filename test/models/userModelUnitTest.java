package models;

import modals.userModal;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertTrue;

/**
 * UserModelUnitTest is setting up the values
 * of the properties of UserModal Class  and then 
 * testing whether the details are for the correct 
 * username.
 * @see userModal
 * @see userModelUnitTest
 * @author Tejpreet Kaur
 *
 */

public class userModelUnitTest {
    userModal user;

    /**
     * Method annotate with @Before will execute before
     * each test method in this class is executed.
     *
     * Setup Method is  setting values of the properties
     * of the userModal class.
     * @author Tejpreet Kaur
     */
    @Before
    public void setup() {
        user = new userModal();
        user.setName("Narendra Garg");
        user.setEmail("narendragarg@gmail.com");
        user.setScreenName("NarendraGarg001");
        user.setLocation("Roorkee, India");
        user.setDescription("Everything comes to u in the right moments be patient....#BePossitive");
        user.setFollowersCount(23);
        user.setUrl("https://t.co/jMNJDmDucO");
        user.setBiggerProfileImageURLHttps("https://pbs.twimg.com/profile_images/921632924239319040/2OMh0tGc_bigger.jpg");
        user.setIsProtected(false);
        List<String> timeline = new ArrayList<String>();
        timeline.add("RT @DNN_Blockchain: Following the success of our pre-sale and consultation with our community, our public sale start date has been delayed…");
        user.setTimeline(timeline);
    }

    /**
    * public void testUserModal annotate with @Test will be executed
    * as a Test case.
    * Unit Test for checking whether the screenName is correct
    * for the provide profile details.
    */
    @Test
    public void testUserModal() {
        assertTrue(user.getScreenName() == "NarendraGarg001");
    }
}

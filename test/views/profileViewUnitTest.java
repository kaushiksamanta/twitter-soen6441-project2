package views;

import java.util.ArrayList;
import java.util.List;
import modals.userModal;
import org.junit.Before;
import org.junit.Test;
import play.test.WithApplication;
import play.twirl.api.Content;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * profileViewUnitTest class contains all the test methods to test profile view.
 * @author Tejpreet Kaur
 */
public class profileViewUnitTest extends WithApplication {
	userModal user;

	/**
	 * setup method is used to create userModal object.
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
	 * renderTemplate method contains assertions.
	 * @author Tejpreet Kaur
	 */
	@Test
	public void renderTemplate() {
	  Content html = views.html.profile.render(user);
	  assertThat("text/html").isEqualTo(html.contentType());
	  assertThat(html.body()).contains("User Profile");
	}
}

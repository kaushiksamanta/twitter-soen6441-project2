package views;
import org.junit.Test;
import play.test.WithApplication;
import play.twirl.api.Content;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * indexViewUnitTest class contains all the test methods to test index view.
 * @author Tejpreet Kaur
 */
public class indexViewUnitTest extends WithApplication {

	/**
	 * renderTemplate method contains assertions.
	 * @author Tejpreet Kaur
	 */

	@Test
	public void renderTemplate() {
	  Content html = views.html.index.render("Welcome to TweetAnalytics");
	  assertThat("text/html").isEqualTo(html.contentType());
	  assertThat(html.body()).contains("Welcome to TweetAnalytics");
	}
}
package controller;

import static org.junit.Assert.assertTrue;
import controllers.ProfileController;
import org.junit.Test;
import static org.junit.Assert.*;
import play.mvc.Result;
import java.util.concurrent.*;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import akka.actor.ActorSystem;
import static org.mockito.Mockito.*;

/**
 * ProfileControllerUnitTest  class contains a method to
 * test the working of the Profile Controller class on the
 * profile details of the twitter users.
 * @see ProfileController
 * @see profileControllerUnitTest
 * @author Tejpreet Kaur
 *
 */

public class profileControllerUnitTest {
	/**
	 * public void testProfile annotate with @Test will be executed as
	 * a Test Case.
	 * Unit Test to test the  whether the Twitter Profile details exists
	 * for a given twitter username .
	 * @author Tejpreet Kaur
	 */
	private ProfileController profileo;
	@InjectMocks
	private ProfileController profileobj;

	final ActorSystem system = ActorSystem.create( "system" ) ;

	public void test() throws Exception{
		profileo = mock(ProfileController.class);
	}

	@Test
	public void testProfileController() throws Exception{
		profileobj = new ProfileController( system );
		MockitoAnnotations.initMocks( this );
		assertNotNull(profileobj);

	}

	@Test
	public void testProfile() throws Exception{
		CompletionStage<Result> result = new ProfileController(system).profile("HikkanAndrey");
		CompletableFuture<Result> r = result.toCompletableFuture();
		assertTrue(r.get().toString().length()>0);
	}
}
package controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static play.mvc.Http.Status.OK;
import static play.test.Helpers.*;
import controllers.IndexController;
import org.junit.Test;
import play.mvc.Result;


/** 
 * IndexControllerUnitTest class contains the actions to test
 *   various properties  of the application's search page.
 * @version 1.0
 * @author Tejpreet Kaur
 *
 */

public class indexControllerUnitTest {
	
	/**
	 * public void testIndex annotate with @Test will be
	 * executed as a Test Case.
	 * Unit Test for the root method of the class IndexController.
	 * In this Test Case , we are checking if the welcome search page
	 * is being shown.
     * @author Tejpreet Kaur
	 */
	
    @Test
    public void testIndex() {
        Result result = new IndexController().root();
        assertEquals(OK, result.status());
        assertEquals("text/html", result.contentType().get());
        assertEquals("utf-8", result.charset().get());
        assertTrue(contentAsString(result).contains("Welcome to TweetAnalytics"));
    }
}

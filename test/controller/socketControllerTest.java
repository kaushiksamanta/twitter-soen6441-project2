package controller;

import akka.actor.ActorSystem;
import akka.stream.Materializer;
import static org.junit.Assert.assertTrue;
import controllers.socketController;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

/**
 * socketControllerTest  class contains a method to
 * test the working of the Spcket Controller class on the
 * socket actor .
 * @see socketController
 * @see socketControllerTest
 * @author Tejpreet Kaur
 *
 */

public class socketControllerTest {

    private  ActorSystem actorSystem;
    private  Materializer materializer;
    private socketController socketo;
    @InjectMocks
    private socketController socketobj;

    public void test() throws Exception{
        socketobj=mock(socketController.class);
    }

    /**
     * public void testsocketcontroller annotate with @Test will be executed as
     * a Test Case.
     * Unit Test to test the  whether the Socket controller details exists.
     * @author Tejpreet Kaur
     */
    @Test
    public void testsocketcontroller() throws Exception{
        socketo=new socketController(actorSystem,materializer);
        MockitoAnnotations.initMocks( this );
        assertTrue(socketo!=null);
    }
}
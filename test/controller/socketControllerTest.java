package controller;

import akka.actor.ActorSystem;
import akka.stream.Materializer;
import static org.junit.Assert.assertTrue;
import controllers.socketController;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class socketControllerTest {

    private  ActorSystem actorSystem;
    private  Materializer materializer;
    private socketController socketo;
    @InjectMocks
    private socketController socketobj;

    public void test() throws Exception{
        socketobj=mock(socketController.class);
    }

    @Test
    public void testsocketcontroller() throws Exception{
        socketo=new socketController(actorSystem,materializer);
        MockitoAnnotations.initMocks( this );
        assertTrue(socketo!=null);
    }
}
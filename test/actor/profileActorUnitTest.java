package actor;

import akka.testkit.javadsl.TestKit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import static org.junit.Assert.assertTrue;

public class profileActorUnitTest {

    static ActorSystem system;

    @BeforeClass
    public static void setup() {
        system = ActorSystem.create();
    }

    @AfterClass
    public static void teardown() {
        TestKit.shutdownActorSystem(system);
        system = null;
    }

    @Test
    public void testIt() {
        new TestKit(system) {{
            final Props props = Props.create(profileActor.class);
            final ActorRef subject = system.actorOf(props);
            subject.tell("NarendraGarg001", getRef());
            assertTrue(getRef().toString().length() > 0);
        }};
    }
}

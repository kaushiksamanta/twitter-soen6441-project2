package controllers;

import actor.socketActor;
import play.libs.F;
import play.libs.streams.ActorFlow;
import akka.actor.*;
import akka.stream.*;
import play.mvc.*;
import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
/**
 * socketController class contains a socket method
 * passes the data from front end  to the socket actor
 * @version 1.0
 * @see socketController
 * @author Kaushik Samanta
 */

@Singleton
public class socketController extends Controller {

    /**
     * This method opens a websocket connection between client and socketController.
     *
     * @author Kaushik Samanta
     * @param username  a ScreenName of the user
     * @return  the user details and timeline to the profile.scala.html
     *
     */

    private final Logger logger = org.slf4j.LoggerFactory.getLogger("controllers.socketController");

    // Websocket interface
    private final ActorSystem actorSystem;
    private final Materializer materializer;

    @Inject
    public socketController(ActorSystem actorSystem, Materializer materializer) {
        this.actorSystem = actorSystem;
        this.materializer = materializer;
    }

    public WebSocket socket() {

        return WebSocket.Text.acceptOrResult(request -> {
            if (sameOriginCheck(request)) {
                return CompletableFuture.completedFuture(
                        F.Either.Right(ActorFlow.actorRef(socketActor::props,
                                actorSystem, materializer)));
            } else {
                return CompletableFuture.completedFuture(F.Either.Left(forbidden()));
            }
        });
    }

    /**
     * Checks that the WebSocket comes from the same origin.  This is necessary to protect
     * against Cross-Site WebSocket Hijacking as WebSocket does not implement Same Origin Policy.
     * <p>
     * See https://tools.ietf.org/html/rfc6455#section-1.3 and
     * http://blog.dewhurstsecurity.com/2013/08/30/security-testing-html5-websockets.html
     */
    private boolean sameOriginCheck(Http.RequestHeader rh) {
        final Optional<String> origin = rh.header("Origin");

        if (! origin.isPresent()) {
            logger.error("originCheck: rejecting request because no Origin header found");
            return false;
        } else if (originMatches(origin.get())) {
            logger.debug("originCheck: originValue = " + origin);
            return true;
        } else {
            logger.error("originCheck: rejecting request because Origin header value " + origin + " is not in the same origin");
            return false;
        }
    }

    private boolean originMatches(String origin) {
        return origin.contains("localhost:9000") || origin.contains("localhost:19001");
    }
}

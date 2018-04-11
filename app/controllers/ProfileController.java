package controllers;

import actor.profileActor;
import akka.actor.*;
import modals.userModal;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;
import javax.inject.*;
import scala.compat.java8.FutureConverters;
import java.util.concurrent.CompletionStage;
import static akka.pattern.Patterns.ask;

/**
 * ProfileController controller class contains a profile method
 * which gets the details of the user from twitterService
 * @version 1.0
 * @see ProfileController
 * @author Kaushik Samanta
 */

@Singleton
public class ProfileController extends Controller{
    /**
     * An action that renders an HTML page with the user profile details.
     * The configuration in the routes file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/userProfile/:username</code>
     *
     * @author Kaushik Samanta
     * @param username  a ScreenName of the user
     * @return  the user details and timeline to the profile.scala.html
     *
     */

    private final ActorRef ProfileActor;

    @Inject public ProfileController(ActorSystem system) {
        ProfileActor = system.actorOf(profileActor.getProps());
    }

    public CompletionStage<Result> profile(String username) {
        return FutureConverters.toJava(ask(ProfileActor, new profileActor.profileMailbox(username),5000))
                .thenApply(response -> ok(profile.render((userModal)response)));
    }
}

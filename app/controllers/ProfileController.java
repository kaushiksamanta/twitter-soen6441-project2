package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import twitter4j.TwitterException;
import services.twitterService;
import views.html.*;
import java.util.concurrent.CompletionStage;


/**
 * ProfileController controller class contains a profile method
 * which gets the details of the user from twitterService
 * @version 1.0
 * @see ProfileController
 * @author Kaushik Samanta
 */

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
     * @throws TwitterException It throws a TwitterException
     *
     */

    public CompletionStage<Result> profile(String username) throws TwitterException {
        return twitterService.getUserDetails(username).thenApplyAsync((details -> ok(profile.render(details))));
    }
}

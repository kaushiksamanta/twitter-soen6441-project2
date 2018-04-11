package actor;

import akka.actor.AbstractActor;
import akka.actor.Props;
import services.twitterService;

/**
 * profileActor Actor class communicates with the
 * Twitter API and fetches all the User details of
 * the given username.
 * @version 1.0
 * @see profileActor
 * @author Kaushik Samanta
 */
public class profileActor extends AbstractActor {

    public static Props getProps() {
        return Props.create(profileActor.class);
    }

    public static class profileMailbox {
        public final String username;

        public profileMailbox(String username) {
            this.username = username;
        }
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(profileMailbox.class, mailbox -> {
                    sender().tell(twitterService.getUserDetails(mailbox.username), self());
                })
                .build();
    }
}

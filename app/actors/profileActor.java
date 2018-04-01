package actors;

import akka.actor.AbstractActor;
import akka.actor.Props;
import services.twitterService;

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

package mocks;

import modals.userModal;

/**
 * * userData is the modal class for Twitter Users
 * @version 1.0
 * @see userData
 * @author Kaushik Samanta
 */

public class userData {
    userModal user;

    public void setuserData(userModal tweets) {
        this.user = tweets;
    }

    public userModal getuserData() {
        return this.user;
    }
}

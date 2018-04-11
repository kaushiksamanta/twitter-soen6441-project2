package mocks;

import modals.userModal;

public class userData {
    userModal user;

    public void setuserData(userModal tweets) {
        this.user = tweets;
    }

    public userModal getuserData() {
        return this.user;
    }
}

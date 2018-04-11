package mocks;

import com.fasterxml.jackson.databind.node.ArrayNode;

public class tweets {

    ArrayNode tweets;

    public void setTweets(ArrayNode tweets) {
        this.tweets = tweets;
    }

    public ArrayNode getTweets() {
        return this.tweets;
    }
}

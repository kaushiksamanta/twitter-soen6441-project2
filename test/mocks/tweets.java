package mocks;

import com.fasterxml.jackson.databind.node.ArrayNode;

/**
 * tweets  class is the tweet modal.
 * @version 1.0
 * @see tweets
 * @author Kaushik Samanta
 */

public class tweets {

    ArrayNode tweets;

    public void setTweets(ArrayNode tweets) {
        this.tweets = tweets;
    }

    public ArrayNode getTweets() {
        return this.tweets;
    }
}

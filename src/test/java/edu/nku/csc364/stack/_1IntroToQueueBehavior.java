package edu.nku.csc364.stack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static com.google.common.truth.Truth.assertThat;

/**
 * This lesson was inspired by Scam School's video
 * https://www.youtube.com/watch?v=XHcUnytN9CI&t=26s
 *
 * Image you have a deck of 7 cards consisting of 4 Kings (K)
 * and 3 Queens (Q). You put the first card on the bottom of the
 * deck, then deal the next card. Then you put a card on the bottom
 * and then deal a card. You repeat this process until there are no
 * cards left. Once the cards are dealt, they should be in alternative
 * order:
 *
 *  K Q K Q K Q K
 *
 * Knowing these rules and using a Queue data structure, how can
 * you load the cards into the Queue so that they end up in the
 * expected order.
 *
 * By using a Queue, we can capture this behavior by leveraging the
 * {@link Queue#offer} and {@link Queue#poll} methods. Your goal is
 * to fill in the blanks to make the test case pass.
 *
 * We will use the strings "K" and "Q" to represent the cards.
 *
 *
 */
public class _1IntroToQueueBehavior {

    String ___;

    @Test
    public void alternateCards() {
        /**
         * There are a lot of implementation of {@link Queue} and
         * a lot of them have to do with concurrency.
         * We will use a {@link LinkedList} as it is one of the simplest
         * implementations.
         */
        Queue<String> q = new LinkedList<>();

        q.offer(___);
        q.offer(___);
        q.offer(___);
        q.offer(___);
        q.offer(___);
        q.offer(___);
        q.offer(___);

        StringBuilder sb = new StringBuilder();
        while(! q.isEmpty() ) {
            q.offer(q.poll());
            sb.append(q.poll());
        }

        assertThat(sb.toString()).isEqualTo("KQKQKQK");
    }
}

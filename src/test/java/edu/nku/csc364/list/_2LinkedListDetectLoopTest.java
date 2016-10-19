package edu.nku.csc364.list;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Implement {@link SimpleLinkedList#hasLoop()} ()} so
 * it returns true or false depending on if a loop is
 * detected in the list.
 *
 */
public class _2LinkedListDetectLoopTest {

    SimpleLinkedList<String> list;

    @Before
    public void setup() {
        list = new SimpleLinkedList<>();
    }

    /**
     * This test will check if following linked list
     * has a loop, which it does
     *
     *  a -> b -> c -> d -
     *       ^            |
     *       |            |
     *        ------------
     */
    @Test
    public void hasLoop() {

        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);
        d.setNext(b);

        list.setHead(a);

        assertThat(list.hasLoop()).isTrue();
    }

    /**
     * This test will check if following linked list
     * has a loop, which it does not
     *
     *  a -> b -> c -> d
     */
    @Test
    public void hasLoop_noLoopExists() {

        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        Node<String> d = new Node<>("D");
        a.setNext(b);
        b.setNext(c);
        c.setNext(d);

        list.setHead(a);

        assertThat(list.hasLoop()).isFalse();
    }

}

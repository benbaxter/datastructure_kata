package edu.nku.csc364.list;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * Implement {@link SimpleLinkedList#reverse()} so
 * it returns a list of the element's data in reverse
 * order.
 *
 * Solve this without adding a previous reference to
 * the Node class. Also, solve this in O(n) time.
 *
 */
public class _4LinkedListReverseTest {

    SimpleLinkedList<String> list;

    @Before
    public void setup() {
        list = new SimpleLinkedList<>();
    }

    /**
     * To solve this without using a secondary buffer, knowing the previous
     * node, and to do this in O(n), we will need to leverage recursion.
     *
     * If we use head recursion (Check base case to quit, then dig
     * further recursively, then perform action) we will be able to
     * solve this quickly and elegantly.
     *
     * We still have to implement reverse() but we can make a helper
     * method reverse(Node n, List path) that can do the recursive work
     * for us.
     */
    @Test
    public void reverse() {
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.insert("d");
        list.insert("e");

        final List<String> reverse = list.reverse();

        assertThat(reverse).containsExactly("e", "d", "c", "b", "a");
    }
}

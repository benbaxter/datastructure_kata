package edu.nku.csc364.list;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Implement {@link SimpleLinkedList#kthFromLast(int)} so
 * it returns the kth from the end element.
 *
 * For example, if we had the following linked list:
 *
 * a -> b -> c -> d -> e -> f -> g
 *
 * Kth from last, with a k value of 3 would ask for the
 * 3rd from last element, which would be 'e'.
 *
 * If we knew the size, this problem is really simple.
 * Just follow the links (size - k) times and return that
 * node.
 *
 * To help you master the runner pattern, assume you
 * do not know the size of the list. You have a reference
 * to head in the SimpleLinkedList and that is all you
 * will need to solve this problem.
 *
 */
public class _6LinkedListKthFromLastTest {

    SimpleLinkedList<String> list;

    @Before
    public void setup() {
        list = new SimpleLinkedList<>();
    }

    @Test
    public void kthFromLast() {
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.insert("e");
        list.insert("f");
        list.insert("g");

        final String result = list.kthFromLast(3);
        assertThat(result).isEqualTo("e");
    }

    @Test
    public void kthFromLast_KisToBig() {
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.insert("e");
        list.insert("f");
        list.insert("g");

        final String result = list.kthFromLast(100);
        assertThat(result).isEqualTo(null);
    }
}

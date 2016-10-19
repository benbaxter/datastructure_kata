package edu.nku.csc364.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/**
 * Implement {@link SimpleLinkedList#removeDups()} and
 * {@link SimpleLinkedList#removeDupsWithoutBuffer()} so
 * that it will remove duplicate values from the linked list.
 *
 * This can be done multiple ways.
 * 1. Using a buffer to keep track of previously seen values
 * 2. Using two runners to iterate through the list
 *
 * Solution 1 takes O(n) time but also takes up to O(n) extra space.
 * Solution 2 takes O(n^2) time but takes O(1) space
 *
 */
public class _1LinkedListRemoveDupsTest {

    SimpleLinkedList<Integer> list;

    @Before
    public void setup() {
        list = new SimpleLinkedList<>();
    }

    /**
     * This and the next test are example tests to show that insert works
     * and how to go about testing your list's values
     */
    @Test
    public void insert_empty() {
        assertThat(list.getFirst()).isNull();
    }

    @Test
    public void insert_head() {
        list.insert(7);

        assertListIs(list.getFirst(), 7);
    }

    @Test
    public void insert_full() {
        list.insert(7);
        list.insert(8);
        list.insert(9);

        assertListIs(list.getFirst(), 7, 8, 9);
    }


    @Test
    public void removeDups() {

        list.insert(7);
        list.insert(8);
        list.insert(7);
        list.insert(7);
        list.insert(7);
        list.insert(9);
        list.insert(7);

        list.removeDups();

        assertListIs(list.getFirst(), 7, 8, 9);
    }

    @Test
    public void removeDupsWithoutBuffer() {

        list.insert(7);
        list.insert(8);
        list.insert(7);
        list.insert(7);
        list.insert(7);
        list.insert(9);
        list.insert(7);

        list.removeDupsWithoutBuffer();

        assertListIs(list.getFirst(), 7, 8, 9);
    }

    private void assertListIs(Node<Integer> head, Integer... vals) {
        List<Integer> ints = Arrays.asList(vals);
        Node<Integer> node = head;
        List<Integer> list = new ArrayList<>();
        while( node != null ) {
            list.add(node.getData());
            node = node.getNext();
        }
        assertThat(list).isEqualTo(ints);
    }

}

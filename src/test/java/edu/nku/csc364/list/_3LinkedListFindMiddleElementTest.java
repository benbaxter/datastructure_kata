package edu.nku.csc364.list;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Implement {@link SimpleLinkedList#middle()} so
 * it returns the middle element in a linked list.
 *
 * You must solve this without knowing the size
 * of the list.
 *
 */
public class _3LinkedListFindMiddleElementTest {

    SimpleLinkedList<String> list;

    @Before
    public void setup() {
        list = new SimpleLinkedList<>();
    }

    /**
     * Without knowing the size of the list,
     * we will have to use the runner technique
     * again. Image the following list:
     *
     *  1 -> 3 -> 5 -> 7 -> 9
     *
     * The middle number is clearly 5 but how did
     * we obtain that information? We say the list
     * has 5 elements and cut that in half.
     *
     * We can do something similar with the
     * runner technique.If we setup 2 runners,
     * one that moves twice as fast as the other,
     * then the slower runner will be at the half
     * way point by the time the faster one hits the
     * end of the list.
     *
     * To demonstrate, lets watch the runners each step
     * of the way.
     *
     * Runners: f (fast), s (slow)
     * List 1 -> 3 -> 5 -> 7 -> 9
     *
     * Step 1:
     * f/s
     *  1 -> 3 -> 5 -> 7 -> 9
     * Step 2:
     *       s    f
     *  1 -> 3 -> 5 -> 7 -> 9
     * Step 3:
     *            s         f
     *  1 -> 3 -> 5 -> 7 -> 9
     * Step 4:
     *                 s        f = null, we went to far
     *  1 -> 3 -> 5 -> 7 -> 9
     *
     *  As long as we check the faster runner before moving,
     *  we can capture the middle with the slower runner
     *
     *
     */
    @Test
    public void middle() {
        list.insert("1");
        list.insert("3");
        list.insert("5");
        list.insert("7");
        list.insert("9");

        final Node<String> middle = list.middle();

        assertThat(middle).isNotNull();
        assertThat(middle.getData()).isEqualTo("5");
    }

    @Test
    public void middle_evenList() {
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.insert("d");
        list.insert("e");
        list.insert("f");
        list.insert("g");

        final Node<String> middle = list.middle();

        assertThat(middle).isNotNull();
        assertThat(middle.getData()).isEqualTo("d");
    }

    @Test
    public void middle_onlyHead() {
        list.insert("a");

        final Node<String> middle = list.middle();

        assertThat(middle).isNotNull();
        assertThat(middle.getData()).isEqualTo("a");
    }

    @Test
    public void middle_noHead() {
        final Node<String> middle = list.middle();

        assertThat(middle).isNull();
    }

}

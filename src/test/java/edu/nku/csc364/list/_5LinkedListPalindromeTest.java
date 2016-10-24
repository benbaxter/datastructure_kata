package edu.nku.csc364.list;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Implement {@link SimpleLinkedList#isPalindrome()} so
 * it returns true or false if the link list data represents
 * a palindrome.
 *
 * A palindrome is represented as the same forward as backwards.
 * For example
 *
 * 1 -> 2 -> 3 -> 2 -> 1 is a palindrome but
 * 1 -> 2 -> 3 -> 2 -> 2 is not.
 *
 * A trivial solution would be to obtain the reverse  of the linked
 * list (previous kata) and test if it is the same as the current list.
 * However, you are smarter than that and can do this in maximum n operations.
 *
 * Solve this without adding a previous reference to
 * the Node class. Also, solve this in O(n) time.
 *
 */
public class _5LinkedListPalindromeTest {

    SimpleLinkedList<String> list;

    @Before
    public void setup() {
        list = new SimpleLinkedList<>();
    }

    /**
     * To solve this without using a secondary buffer, knowing the previous
     * node, and to do this in O(n) without obtaining the reverse, we will
     * can use the runner technique.
     *
     * If we think about what a palindrome is, it is just the first half
     * is equal to the reverse of the second half. So,
     * a -> b -> c -> b -> a can we evauluated as
     * does `a -> b` (skip c since it is an odd sized list^) equal
     * `b -> a` reversed.
     *
     * ^Trick: if fast still has a next, then we have an odd sized list
     *
     * If we flip this thinking, we can compare that the reverse of the
     * first half is equal to the second half.
     *
     * So we just need to 'reverse' the nodes in the back ticks (`)
     * `a -> b` -> c -> b -> a
     *
     * A stack is a good way to keep track of this! We can use the runner
     * technique from our middle algorithm and extend it to leverage a stack
     * to keep track of the first half in reverse order.
     *
     * Stack {}
     * Runners f/s
     * List a -> b -> c -> b -> a
     *
     * Step 1:
     * Stack { a }
     * s         f
     * a -> b -> c -> b -> a
     *
     * Step 2:
     * Stack { b, a }
     *      s              f
     * a -> b -> c -> b -> a
     *
     * Now the slow runner is in the middle ish. Need to adjust for the odd sized list.
     *
     * Stack { b, a }
     *           s
     * a -> b -> c -> b -> a
     *
     * We can pop off the stack and progress our slow runner as long as they are not null
     * and they popped value equals slow's value, we have a palindrome. Here is the rest
     * of the example
     *
     * Stack {  a }
     *                s
     * a -> b -> c -> b -> a
     *
     * popped = b
     * slow.data = b
     *
     * Stack {}
     *                     s
     * a -> b -> c -> b -> a
     *
     * popped = a
     * slow.data = a
     *
     */
    @Test
    public void isPalindrome() {
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.insert("b");
        list.insert("a");

        assertThat(list.isPalindrome()).isTrue();
    }

    @Test
    public void isPalindrome_evenNumber_abba() {
        list.insert("a");
        list.insert("b");
        list.insert("b");
        list.insert("a");

        assertThat(list.isPalindrome()).isTrue();
    }

    @Test
    public void isPalindrome_evenNumber_abab() {
        list.insert("a");
        list.insert("b");
        list.insert("a");
        list.insert("b");

        assertThat(list.isPalindrome()).isFalse();
    }

    @Test
    public void isPalindrome__abcbb() {
        list.insert("a");
        list.insert("b");
        list.insert("c");
        list.insert("b");
        list.insert("b");

        assertThat(list.isPalindrome()).isFalse();
    }

    @Test
    public void isPalindrome__a() {
        list.insert("a");

        assertThat(list.isPalindrome()).isTrue();
    }
}

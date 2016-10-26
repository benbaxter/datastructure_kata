package edu.nku.csc364.stack;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;


/**
 * Some properties of stack is that the pop and push
 * operate in O(1) time. We want to add another function
 * that will return the min element in the stack in O(1)
 * time as well.
 *
 * Implement {@link MinStack#min()} to satisfy the
 * tests.
 *
 * Hint: You may need to modify the pop/push/peek functions.
 *
 */
public class _1MinStackTest {

    MinStack stack;

    @Before
    public void setup() {
        stack = new MinStack();
    }


    /**
     * The thing with minimums is that they don't change very often.
     * They only change when a smaller element is added.
     *
     * One solution is to have just a single int value, minValue, that's
     * a member of the Stack class. When minValue is popped from the stack,
     * we search through the stack to find the new minimum. Unfortunately,
     * this would break the constraint that push and pop operate in 0(1) time.
     *
     * To further understand this question, let's walk through it with a short example:
     * push(5); // stack is {5}, min is 5
     * push(6); // stack is {6, 5}, min is 5
     * push(3); // stack is {3, 6, 5}, min is 3
     * push(7); // stack is {7, 3, 6, 5}, min is 3
     * pop(); // pops 7. stack is {3, 6, 5}, min is 3
     * pop(); // pops 3. stack is {6., 5}. min is 5.
     *
     * Observe how once the stack goes back to a prior state({6, 5}),
     * the minimum also goes back to its prior state (5). This leads
     * us to a second solution.
     *
     * If we kept track of the minimum at each state, we would be able
     * to easily know the minimum. We can do this by having each node
     * record what the minimum beneath itself is. Then, to find the min,
     * you just look at what the top element thinks is the min.
     *
     * When you push an element onto the stack, the element is given
     * the current minimum. It sets its "local min" to be the min.
     *
     * We can accomplish this by making an extra node class that
     * keeps track of a local min.
     *
     * class NodeWithMin {
     *     int data;
     *     int min;
     *     //Constructor for member variables
     * }
     *
     */
    @Test
    public void min() {
        //testing with the example data above
        stack.push(5);
        stack.push(6);

        assertThat(stack.min()).isEqualTo(5);

        stack.push(3);
        stack.push(7);

        assertThat(stack.min()).isEqualTo(3);

        stack.pop();
        stack.pop();

        assertThat(stack.min()).isEqualTo(5);
    }

    @Test
    public void min_emptyStack() {
        assertThat(stack.min()).isEqualTo(Integer.MIN_VALUE);
    }

    @Test
    public void min_dups() {
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(6);

        assertThat(stack.min()).isEqualTo(5);

        stack.push(3);
        stack.push(7);
        stack.push(3);
        stack.push(3);
        stack.push(3);

        assertThat(stack.min()).isEqualTo(3);

        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();
        stack.pop();

        assertThat(stack.min()).isEqualTo(5);

        stack.pop();
        stack.pop();

        assertThat(stack.min()).isEqualTo(5);
    }
}
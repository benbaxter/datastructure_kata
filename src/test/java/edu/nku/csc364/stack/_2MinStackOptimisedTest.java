package edu.nku.csc364.stack;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;


/**
 * Building off of the previous problem, we can optimize it a little more.
 *
 * When we have a large stack, we waste a lot of space by keeping track of
 * the min for every single element. We can do better!
 *
 * We can (maybe) do a bit better than this by using an additional stack
 * which keeps track of the mins.
 *
 * Implement {@link MinStackOptimized#min()} such that it has an
 * auxiliary stack to minimize the space needed to keep track of the minimum
 * value.
 *
 */
public class _2MinStackOptimisedTest {

    MinStackOptimized stack;

    @Before
    public void setup() {
        stack = new MinStackOptimized();
    }

    @Test
    public void min() {
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
        assertThat(stack.min()).isEqualTo(Integer.MAX_VALUE);
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

    @Test
    public void min_poppedToMany() {
        stack.push(3);
        assertThat(stack.min()).isEqualTo(3);
        //pop it back off
        stack.pop();
        assertThat(stack.min()).isEqualTo(Integer.MAX_VALUE);
        //pop again even though the stack should be empty, we should still handle this
        stack.pop();
        assertThat(stack.min()).isEqualTo(Integer.MAX_VALUE);
    }
}
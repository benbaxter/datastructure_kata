package edu.nku.csc364.stack;

import java.util.Stack;

/**
 * A class that encapsulates a stack and performs
 * extra operations such as min, max, sum, etc.
 */
public class StackExtensions<T> extends Stack<T> {

    //using a java.util.Stack since there is no need to reinvent the wheel
    private Stack<T> stack;

    public StackExtensions() {
        stack = new Stack<>();
    }

    public T push(T data) {
        return stack.push(data);
    }

    public T peek() {
        return stack.peek();
    }

    public T pop() {
        return stack.pop();
    }

    public T min() {
        return null;
    }
}

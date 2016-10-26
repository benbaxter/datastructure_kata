package edu.nku.csc364.stack;

import java.util.Stack;

/**
 * A class that encapsulates a stack and performs
 * extra operations such as min, max, sum, etc.
 */
public class StackExtensions extends Stack<Integer> {

    //using a java.util.Stack since there is no need to reinvent the wheel
    private Stack<Integer> stack;

    public StackExtensions() {
        stack = new Stack<>();
    }

    @Override
    public Integer push(Integer data) {
        return stack.push(data);
    }

    @Override
    public Integer peek() {
        return stack.peek();
    }

    @Override
    public Integer pop() {
        return stack.pop();
    }

    public Integer min() {
        return null;
    }
}

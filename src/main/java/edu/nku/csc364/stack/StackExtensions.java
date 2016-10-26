package edu.nku.csc364.stack;

import java.util.Stack;

/**
 * A class that encapsulates a stack and performs
 * extra operations such as min, max, sum, etc.
 */
public class StackExtensions extends Stack<Integer> {

    //using a java.util.Stack since there is no need to reinvent the wheel
    private Stack<NodeWithMin> stack;

    public StackExtensions() {
        stack = new Stack<>();
    }

    @Override
    public Integer push(Integer data) {
        stack.push(new NodeWithMin(data, Math.min(data, min())));
        return data;
    }

    @Override
    public Integer peek() {
        if( ! stack.isEmpty() ) {
            return stack.peek().getData();
        } else {
            return null;
        }
    }

    @Override
    public Integer pop() {
        if( ! stack.isEmpty() ) {
            return stack.pop().getData();
        } else {
            return null;
        }
    }

    public Integer min() {
        if( stack.isEmpty() ) {
            return Integer.MAX_VALUE;
        }
        return stack.peek().getMin();
    }
}

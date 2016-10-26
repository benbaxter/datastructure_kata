package edu.nku.csc364.stack;

import java.util.Stack;

/**
 * A class that encapsulates a stack and performs
 * extra operations such as min, max, sum, etc.
 */
public class MinStackOptimized extends Stack<Integer> {

    //using a java.util.Stack since there is no need to reinvent the wheel
    private Stack<Integer> stack;

    public MinStackOptimized() {
        stack = new Stack<>();
    }

    @Override
    public Integer push(Integer data) {
        return stack.push(data);
    }

    @Override
    public Integer peek() {
        if( ! stack.isEmpty() ) {
            return stack.peek();
        } else {
            return null;
        }
    }

    @Override
    public Integer pop() {
        if( ! stack.isEmpty() ) {
            return stack.pop();
        } else {
            return null;
        }
    }

    public Integer min() {
        return null;
    }
}

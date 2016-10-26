package edu.nku.csc364.stack;

import java.util.Stack;

/**
 * A class that encapsulates a stack and performs
 * extra operations such as min, max, sum, etc.
 */
public class MinStackOptimized extends Stack<Integer> {

    //using a java.util.Stack since there is no need to reinvent the wheel
    private Stack<Integer> mins;

    public MinStackOptimized() {
        mins = new Stack<>();
    }

    @Override
    public Integer push(Integer data) {
        if( data <= min() ) {
            mins.push(data);
        }
        return super.push(data);
    }

    @Override
    public Integer pop() {
        if( isEmpty() ) {
            return null;
        }
        int data = super.pop();
        if( data == min()) {
            mins.pop();
        }
        return data;
    }

    public Integer min() {
        return mins.isEmpty() ? Integer.MAX_VALUE : mins.peek();
    }
}

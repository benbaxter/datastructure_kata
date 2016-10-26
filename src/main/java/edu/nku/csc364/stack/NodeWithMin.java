package edu.nku.csc364.stack;

/**
 * A small node class to keep track of a local min in a stack
 */
public class NodeWithMin {

    private int data;
    private int min;

    public NodeWithMin(int data, int min) {
        this.data = data;
        this.min = min;
    }

    public int getData() {
        return data;
    }

    public int getMin() {
        return min;
    }
}

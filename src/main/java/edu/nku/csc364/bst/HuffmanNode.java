package edu.nku.csc364.bst;

/**
 * Created by bb77872 on 10/18/16.
 */
public class HuffmanNode {

    private int frequency;
    private char data;
    private HuffmanNode left;
    private HuffmanNode right;

    public HuffmanNode(char data, int frequency) {
        this.frequency = frequency;
        this.data = data;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public HuffmanNode getLeft() {
        return left;
    }

    public void setLeft(HuffmanNode left) {
        this.left = left;
    }

    public HuffmanNode getRight() {
        return right;
    }

    public void setRight(HuffmanNode right) {
        this.right = right;
    }
}

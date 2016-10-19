package edu.nku.csc364.bst;

/**
 * Complete the implementation to make the tests pass
 */
public class HuffmanTree {

    HuffmanNode root;

    public String decode(String code) {

        StringBuilder sb = new StringBuilder();
        HuffmanNode curr = root;
        char[] chars = code.toCharArray();
        for( int i = 0; i < chars.length; ++i ) {
            if( chars[i] == '0' ) {
                curr = curr.getLeft();
            } else {
                curr = curr.getRight();
            }
            if( curr.getLeft() == null && curr.getRight() == null ) {
                sb.append(curr.getData());
                curr = root;
            }
        }

        return sb.toString();
    }

    protected void setRoot(HuffmanNode root) {
        this.root = root;
    }
}

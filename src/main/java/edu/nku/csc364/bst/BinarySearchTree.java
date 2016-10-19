package edu.nku.csc364.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Complete the implementation to make the tests pass
 */
public class BinarySearchTree {

    Node root;

    public Node insert(int value) {
        return null;
    }

    public int height() {
        return -1;
    }

    public List<Integer> topView() {

        return Collections.emptyList();
    }

    public List<Integer> levelOrderTraversal() {

       return Collections.emptyList();
    }

    public List<Integer> inorder() {
        List<Integer> inorder = new ArrayList<>();
        inorder(root, inorder);
        return inorder;
    }

    private void inorder(Node root, List<Integer> path) {
        if( root == null ) {
            return;
        }
        inorder(root.getLeft(), path);
        path.add(root.getData());
        inorder(root.getRight(), path);
    }
}

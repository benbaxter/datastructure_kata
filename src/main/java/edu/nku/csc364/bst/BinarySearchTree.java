package edu.nku.csc364.bst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Complete the implementation to make the tests pass
 */
public class BinarySearchTree {


    Node root;

    public Node insert(int value) {
        root = insert(root, new Node(value));
        return root;
    }

    private Node insert(Node root, Node node) {
        if( root == null ) {
            return node;
        }

        if( root.getData() < node.getData() ) {
            root.setRight(insert(root.getRight(), node));
        } else {
            root.setLeft(insert(root.getLeft(), node));
        }

        return root;
    }

    public int height() {
        return height(root, 0);
    }

    private int height(Node root, int height) {
        if( root == null ) {
            return height - 1; //went 1 to far down the tree
        }
        return Math.max(height(root.getLeft(), height + 1), height(root.getRight(), height + 1));
    }

    public List<Integer> topView() {

        if( root == null ) {
            return Collections.emptyList();
        }

        List<Integer> view = new ArrayList<>();
        Node curr = root;
        while( curr.hasLeft() ) {
            curr = curr.getLeft();
            view.add(0, curr.getData());
        }

        view.add(root.getData());

        curr = root;
        while( curr.hasRight() ) {
            curr = curr.getRight();
            view.add(curr.getData());
        }

        return view;
    }

    public List<Integer> levelOrderTraversal() {

        if( root == null ) {
            return Collections.emptyList();
        }

        Queue<Node> q = new LinkedBlockingQueue<>();
        q.add(root);
        List<Integer> order = new ArrayList<>();
        while(! q.isEmpty()) {
            Node curr = q.poll();

            order.add(curr.getData());

            if( curr.hasLeft() ) {
                q.offer(curr.getLeft());
            }
            if( curr.hasRight() ) {
                q.offer(curr.getRight());
            }
        }

        return order;
    }

    public boolean isBST() {

        List<Integer> inorder = inorder();
        for( int i = 1; i < inorder.size(); ++i ) {
            if( inorder.get(i) < inorder.get(i - 1) ) {
                return false; // "i am larger than the guy before me and that is bad"
            }
        }

        return true;
    }

    public boolean isBSTWithoutBuffer() {
        return isBSTWithoutBuffer(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    boolean isBSTWithoutBuffer(Node root, int max, int min) {

        if( root == null ) {
            return true;
        }

        if( root.getData() >= max || root.getData() <= min ) {
            return false;
        }

        return isBSTWithoutBuffer(root.getLeft(), root.getData(), min)
                && isBSTWithoutBuffer(root.getRight(), max, root.getData());
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

    protected void setRoot(Node root) {
        this.root = root;
    }
}

package edu.nku.csc364.bst;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static com.google.common.truth.Truth.assertThat;

/**
 *
 * Given a binary search tree, which contains a root node, and a value
 * to be inserted into the tree; insert this value into its appropriate
 * position in the binary search tree and return the root of the updated
 * binary tree. You just have to complete the {@link BinarySearchTree#insert(int value)}.
 *
 * These are test cases to verify that insert works
 *
 * Test data:
 * 7 9 4 2 6 3 5 1 8
 */
public class _1BinarySearchTreeInsertTest {

    BinarySearchTree tree;

    @Before
    public void setup() {
        tree = new BinarySearchTree();
    }

    @Test
    public void insert_root() {
        tree.insert(7);

        assertThat(tree.inorder()).isEqualTo(Collections.singletonList(7));
    }

    @Test
    public void insert_right() {
        tree.insert(7);
        tree.insert(9);

        assertThat(tree.inorder()).isEqualTo(Arrays.asList(7, 9));
    }

    @Test
    public void insert_left() {
        tree.insert(7);
        tree.insert(4);

        assertThat(tree.inorder()).isEqualTo(Arrays.asList(4, 7));
    }

    @Test
    public void insert_full() {
        tree.insert(7);
        tree.insert(9);
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(3);
        tree.insert(5);
        tree.insert(1);
        tree.insert(8);

        assertThat(tree.inorder()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

}

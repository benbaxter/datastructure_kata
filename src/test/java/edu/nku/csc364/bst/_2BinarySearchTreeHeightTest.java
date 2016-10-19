package edu.nku.csc364.bst;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.google.common.truth.Truth.assertThat;

/**
 *
 * The height of a binary tree is the number of edges between the tree's
 * root and its furthest leaf. This means that a tree containing a single
 * node has a height of 0.
 *
 * Complete the {@link BinarySearchTree#height()} so that it returns the
 * height of a binary tree.
 *
 * These are test cases to verify that your implementation works
 *
 * Test data:
 * 3 5 2 1 4 6 7
 */
public class _2BinarySearchTreeHeightTest {

    BinarySearchTree tree;

    @Before
    public void setup() {
        tree = new BinarySearchTree();
    }

    @Test
    public void height_root() {
        tree.insert(3);

        assertThat(tree.height()).isEqualTo(0);
    }

    @Test
    public void height_full() {
        tree.insert(3);
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(7);

        assertThat(tree.height()).isEqualTo(3);
    }
}

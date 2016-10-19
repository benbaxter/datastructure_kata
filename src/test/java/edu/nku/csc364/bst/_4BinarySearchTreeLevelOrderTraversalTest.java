package edu.nku.csc364.bst;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.google.common.truth.Truth.assertThat;

/**
 *
 * Given a binary tree. You need to collection the level order traversal of this tree.
 * In level order traversal, we visit the nodes level by level from left to right.
 * For example :
 *
 *         3
 *       /  \
 *      2    5
 *     /    / \
 *    1    4   7
 *            /
 *           6
 *
 * LOT : 3 -> 2 -> 5 -> 1 -> 4 -> 7 -> 6
 *
 * Complete the {@link BinarySearchTree#levelOrderTraversal()} so that it returns the
 * values of the top view.
 *
 * These are test cases to verify that your implementation works
 *
 * Test data:
 * 3 5 2 1 4 7 6
 *
 */
public class _4BinarySearchTreeLevelOrderTraversalTest {

    BinarySearchTree tree;

    @Before
    public void setup() {
        tree = new BinarySearchTree();
    }

    @Test
    public void levelOrderTraversal_emptyTree() {
        assertThat(tree.levelOrderTraversal()).isEqualTo(Collections.emptyList());
    }

    @Test
    public void levelOrderTraversal_full() {
        tree.insert(3);
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(7);
        tree.insert(6);

        assertThat(tree.levelOrderTraversal()).isEqualTo(Arrays.asList(3, 2, 5, 1, 4, 7, 6));
    }
}

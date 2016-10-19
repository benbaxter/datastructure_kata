package edu.nku.csc364.bst;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.google.common.truth.Truth.assertThat;

/**
 *
 * Given a binary tree, find the top view of the binary tree.
 * For example :
 *
 *       3
 *     /   \
 *    5     2
 *  /  \   / \
 * 1    4 6   7
 *  \        /
 *   9      8
 *
 * Top View : 1 -> 5 -> 3 -> 2 -> 7
 *
 * Note that this example is for a binary tree, not just a binary search tree. This
 * function can be applied to both types of trees since a bst is a substructure of a
 * binary tree.
 *
 * Complete the {@link BinarySearchTree#topView()} so that it returns the
 * values of the top view.
 *
 * These are test cases to verify that your implementation works
 *
 * Test data:
 * 3 5 2 1 4 7 6
 *
 *         3
 *       /  \
 *      2    5
 *     /    / \
 *    1    4   7
 *            /
 *           6
 *
 * Top View : 1 -> 2 -> 3 -> 5 -> 7
 */
public class _3BinarySearchTreeTopViewTest {

    BinarySearchTree tree;

    @Before
    public void setup() {
        tree = new BinarySearchTree();
    }

    @Test
    public void topview_emptyTree() {
        assertThat(tree.topView()).isEqualTo(Collections.emptyList());
    }

    @Test
    public void topview_full() {
        tree.insert(3);
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(7);
        tree.insert(6);

        assertThat(tree.topView()).isEqualTo(Arrays.asList(1, 2, 3, 5, 7));
    }
}

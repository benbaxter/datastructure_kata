package edu.nku.csc364.bst;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 *
 * Implement {@link BinarySearchTree#isBST()} such that returns
 * true or false if a tree is a binary search tree or not
 *
 *
 * For example the following tree is a binary search tree :
 *               5
 *             /  \
 *            2    6
 *          /  \
 *         1    3
 *
 * Where as this tree is not
 *
 *          20
 *         /  \
 *        10  30
 *          \
 *          25
 *
 * These are test cases to verify that your implementation works
 *
 * One way to solve this is to perform an inorder traversal and verify
 * that the values are sorted. If they are sorted, then they are in the
 * correct place in the tree.
 *
 * Another way to solve this is to leverage the definition of a binary 
 * search tree and use recursion instead of a buffer array.
 * 
 * Solve for both ways
 * 
 * {@link BinarySearchTree#isBST()} and {@link BinarySearchTree#isBSTWithoutBuffer()}
 *
 */
public class _5IsBinarySearchTreeTest {

    BinarySearchTree tree;

    @Before
    public void setup() {
        tree = new BinarySearchTree();
    }

    /**
     * For the first test, we can insert into the tree and then
     * call isBST. Since our insert should be completed by now,
     * and it inserts correctly, then isBST should return true
     */
    @Test
    public void isBST() {

        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);

        assertThat(tree.isBST()).isTrue();
    }

    /**
     * For the second test, we can not use the insert method as that
     * will also be a true tree. So we will initialize a binary tree
     * and override the root of our tree instead.
     */
    @Test
    public void isBST_shouldNotBeABST() {
        initBadTree();

        assertThat(tree.isBST()).isFalse();
    }

    /**
     * This next two test will test the method that should not
     * use a buffer. To solve this, we should analyze our data
     * structure a bit more thoroughly.
     *
     * What does it mean for a tree to be a binary search tree?
     * We know that it must, of course, satisfy the condition
     *
     * left.data <= current.data < right.data
     *
     * for each node, but this isn't quite sufficient as proven
     * with the example detailed above.
     *
     * Although each node is bigger than its left node and smaller
     * than its right node, this is clearly not a binary search
     * tree since 25 is in the wrong place.
     *
     * More precisely, the condition is that all left nodes must be
     * less than or equal to the current node, which must be less
     * than all the right nodes.
     *
     * Using this thought, we can approach the problem by passing down
     * the min and max values. As we iterate through the tree, we
     * verify against progressively narrower ranges.
     *
     * Consider the following sample tree:
     *
     *          20
     *         /  \
     *       10   30
     *      /  \
     *     5   15
     *    / \   \
     *   3  7   17
     *
     * We start with a range of (min = INT_MIN, max = INT_MAX), which the root
     * obviously meets. We then branch left, checking that these nodes are within
     * the range(min = INT_MIN, max = 20). Then, we branch right, checking that
     * the nodes are within the range (min = 10, max = 20).
     *
     * We proceed through the tree with this approach. When we branch left,
     * the max gets updated. When we branch right, the min gets updated. If
     * anything fails these checks, we stop and return false.
     *
     * The time complexity for this solution is 0(N), where N is the number of nodes
     * in the tree. We can prove that this is the best we can do, since any algorithm
     * must touch all N nodes.
     *
     * Due to the use of recursion, the space complexity is0(log N) on a balanced tree.
     * There are up to 0(log N) recursive calls on the stack since we may recurse up
     * to the depth of the tree.
     *
     * Use a recursive helper method to implement the isBST algorithm without the use
     * of a buffer by leveraging this min/max idea instead.
     *
     */
    @Test
    public void isBSTWithoutBuffer() {

        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);

        assertThat(tree.isBSTWithoutBuffer()).isTrue();
    }

    @Test
    public void isBSTWithoutBuffer_shouldNotBeABST() {
        initBadTree();

        assertThat(tree.isBSTWithoutBuffer()).isFalse();
    }

    private void initBadTree() {
        Node root = new Node(20);
        root.setRight(new Node(30));
        root.setLeft(new Node(10));
        root.getLeft().setLeft(new Node(25));
        tree.setRoot(root);
    }
}

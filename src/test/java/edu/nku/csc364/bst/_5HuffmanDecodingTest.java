package edu.nku.csc364.bst;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static com.google.common.truth.Truth.assertThat;

/**
 *
 * Huffman coding assigns variable length codewords to fixed length input
 * characters based on their frequencies. More frequent characters are assigned
 * shorter codewords and less frequent characters are assigned longer codewords.
 * A Huffman tree is made for the input string and characters are decoded based
 * on their position in the tree. We add a '0' to the codeword when we move left
 * in the binary tree and a '1' when we move right in the binary tree. We assign
 * codes to the leaf nodes which represent the input characters.
 *
 *
 * For example :
 *               {ϕ,5}
 *            0 /     \ 1
 *           {ϕ,2}   {A,3}
 *          0/   \1
 *       {B,1}  {C,1}
 *
 *
 * Input characters are only present on the leaves. Internal nodes have a character
 * value of ϕ. Codewords:
 *
 * A - 1
 * B - 00
 * C - 01
 *
 * No codeword appears as a prefix of any other codeword. Huffman encoding is a prefix
 * free encoding technique.
 *
 * Encoded String "1001011" represents the string "ABACA"
 *
 * You have to decode an encoded string using the Huffman tree.
 *
 * You are given a Huffman tree and a binary coded string, you will need to decode the string.
 *
 * Complete the {@link HuffmanTree#decode(String code)} so that it returns the
 * decoded string.
 *
 * These are test cases to verify that your implementation works
 *
 * Test data:
 * 1001011
 *
 */
public class _5HuffmanDecodingTest {

    HuffmanTree tree;

    @Before
    public void setup() {
        tree = new HuffmanTree();
    }

    @Test
    public void decode() {

        initTree();

        assertThat(tree.decode("1001011")).isEqualTo("ABACA");
    }

    private void initTree() {
        HuffmanNode root = new HuffmanNode('ϕ', 5);
        root.setRight(new HuffmanNode('A', 3));
        root.setLeft(new HuffmanNode('ϕ', 2));
        root.getLeft().setLeft(new HuffmanNode('B', 1));
        root.getLeft().setRight(new HuffmanNode('C', 1));
        tree.setRoot(root);
    }
}

package edu.nku.csc364.list;

import java.util.Collections;
import java.util.List;

/**
 * A simple implementation of a linked list.
 *
 * This list contains a reference to the head
 * and performs all operations relative to
 * knowing the head value.
 */
public class SimpleLinkedList<T> {

    private Node<T> head;

    /**
     * This insert operation will always add the new node to
     * the end of linked list
     * @param data
     */
    public void insert(T data) {

        Node<T> node = new Node<>(data);

        if( head == null ) {
            head = node;
            return;
        }

        Node<T> curr = head;
        while( curr.getNext() != null ) {
            curr = curr.getNext();
        }

        curr.setNext(node);
    }

    public void removeDups() {

    }

    public void removeDupsWithoutBuffer() {

    }

    /**
     * An easy way to detect if a linked list has a loop is
     * through the FastRunner / SlowRunner approach. FastRunner
     * moves two steps at a time, while SlowRunner moves one
     * step. Much like two cars racing around a track at different
     * steps, they must eventually meet.
     *
     * An astute reader may wonder if FastRunner might "hopover"
     * SlowRunner completely, without ever colliding. That's not
     * possible. Suppose that FastRunner did hop over SlowRunner,
     * such that SlowRunner is at spot i and FastRunner is at spot
     * i + 1. In the previous step, SlowRunner would be at spot
     * i - 1 and FastRunner would at spot ((i + 1) - 2), or spot
     * i - 1. That is,they would have collided.
     */
    public boolean hasLoop() {
        throw new UnsupportedOperationException("hasLoop has not been implemented");
    }


    public Node<T> middle() {
        return null;
    }

    public List<T> reverse() {
       return Collections.emptyList();
    }

    public boolean isPalindrome() {
        return false;
    }

    public T kthFromLast(int k) {
        return null;
    }

    public Node<T> getFirst() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}

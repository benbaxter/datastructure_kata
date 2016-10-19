package edu.nku.csc364.list;

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

    public Node<T> getFirst() {
        return head;
    }
}

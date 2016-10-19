package edu.nku.csc364.list;

/**
 *
 */
public class SimpleLinkedList<T> {

    private Node<T> head;

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

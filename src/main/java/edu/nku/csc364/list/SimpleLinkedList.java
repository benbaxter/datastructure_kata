package edu.nku.csc364.list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

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
        Set<T> visited = new HashSet<>();
        Node<T> node = head;
        Node<T> previous = null;
        while( node != null ) {
            T data = node.getData();
            if( visited.contains(data) ) {
                previous.setNext(node.getNext());
            } else {
                visited.add(data);
                previous = node;
            }
            node = node.getNext();
        }
    }

    public void removeDupsWithoutBuffer() {
        Node<T> current = head;
        while( current != null ) {
            Node<T> runner = current;
            while(runner.getNext() != null ) {
                if( current.getData().equals(runner.getNext().getData()) ) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            current = current.getNext();
        }
    }

    public Node<T> getFirst() {
        return head;
    }
}

package edu.nku.csc364.list;

import java.util.*;

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
        Node<T> slow = head;
        Node<T> fast = head;

        while( fast != null && fast.getNext() != null ) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if( slow.equals(fast) ) {
                return true;
            }
        }

        return false;
    }


    public Node<T> middle() {
        if( head == null ) {
            return null;
        }

        Node<T> slow = head;
        Node<T> fast = head;
        while( fast.getNext() != null && fast.getNext().getNext() != null ) {
            //we know slow,getNext() will not be null since fast has already passed that node
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    public List<T> reverse() {
        List<T> path = new ArrayList<>();
        reverse(head, path);
        return path;
    }

    private void reverse(Node<T> n, List<T> path) {
        if (n == null) {
            return;
        }
        reverse(n.getNext(), path);
        path.add(n.getData());
    }

    public boolean isPalindrome() {
        if( head == null ) {
            return false;
        }

        Node<T> fast = head;
        Node<T> slow = head;

        Stack<T> stack = new Stack<>();
        while(fast != null && fast.getNext() != null ) {
            stack.push(slow.getData());
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        //skip the middle element for odd sized lists
        if( fast != null ) {
            slow = slow.getNext();
        }

        while( slow != null ) {
            T popped = stack.pop();
            T data = slow.getData();
            if( ! popped.equals(data) ) {
                return false;
            }
            slow = slow.getNext();
        }

        return true;
    }

    public T kthFromLast(int k) {
        Node<T> runner = head;
        while( runner != null && k > 0 ) {
            runner = runner.getNext();
            --k;
        }

        if( runner == null ) {
            return null;
        }

        Node<T> current = head;
        while(runner != null ) {
            runner = runner.getNext();
            current = current.getNext();
        }

        return current.getData();
    }

    public Node<T> getFirst() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }
}

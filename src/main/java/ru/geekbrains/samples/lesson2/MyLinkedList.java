package ru.geekbrains.samples.lesson2;

import java.util.Iterator;
import java.util.Objects;

public class MyLinkedList {
    //here is your path...
    class Node {
        Cat c;
        Node next;
        public Node(Cat c) {
            this.c = c;
        }
        @Override
        public String toString() {
            return String.format("Node(c=%s)", c);
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(c, node.c) &&
                    Objects.equals(next, node.next);
        }
    }
    protected Node head;
    public MyLinkedList() {
        this.head = null;
    }
    public boolean isEmpty() {
        return head == null;
    }
    public void push(Cat c) {
        Node n = new Node(c);
        n.next = head;
        head = n;
    }
    public Cat pop() {
        if (isEmpty()) return null;
        Cat temp = head.c;
        head = head.next;
        return temp;
    }
    public boolean contains(Cat c) {
        Node n = new Node(c);
        Node current = head;
        while (!current.equals(n)) {
            if (current.next == null) return false;
            else current = current.next;
        }
        return true;
    }
    public void delete(Cat c) {
        Node n = new Node(c);
        Node current = head;
        Node previous = null;
        while (!current.equals(n)) {
            if (current.next == null) return;
            else {
                previous = current;
                current = current.next;
            }
        }

        if (current == head) {
            head = head.next;
        } else {
            previous.next = current.next;
        }

        // return current.c

    }

    protected class IteroCat implements Iterator<Cat> {

        private Node currentNode, nextNode, headNode;

        protected IteroCat(Node n) {
            currentNode = null;
            nextNode = n;
            headNode = n;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public Cat next() {
            if (!hasNext()) return null;
            currentNode = nextNode;
            nextNode = nextNode.next;
            return currentNode.c;
        }

        public Cat getCurrent() {
            return (currentNode!=null) ? currentNode.c : nextNode.c;
        }

        public Cat atEnd() {
            Cat result = null;
            while (hasNext()) {
                result = next();
            }
            return result;
        }

        public void reset() {
            currentNode = null;
            nextNode = headNode;
        }

    }

    public IteroCat iterator() {
        return new IteroCat(head);
    }
}

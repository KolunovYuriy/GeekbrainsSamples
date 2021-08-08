package ru.geekbrains.samples.lesson2;

public class DoubleWayLinkedList extends MyLinkedList{
    
    private Node last;
    
    @Override
    public void push(Cat c) {
        super.push(c);
        if (head.next== null) last=head;
    }
    
    public void insertLast(Cat c) {
        if (head == null) {push(c);}
        else {
            Node n = new Node(c);
            n.next = null;
            last.next = n;
            last = n;
        }
    }
    
    @Override
    public IteroCat iterator() {
        return new IteroCat(head);
    }
    
    
}

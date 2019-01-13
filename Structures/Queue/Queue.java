class Node {

    private static int nodeNumber = 0;
    public Node next;
    public int val;

    public Node() {
        this.val = nodeNumber++;
        this.next = null;
    }
}

public class Queue {

    private Node head, tail;

    public void enqueue() {
        if(head == null) {
            head = new Node();
            tail = head;
        }
        else {
            //rewire the head
            Node temp = new Node();
            temp.next = head;
            head = temp;
        }
    }

    public void dequeue() {
        if(head == null) {
            System.out.println("Empty queue");
        }
        else if(head.next == null) {
            head = null;
        }
        else {
            Node temp = head;
            while(temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
    }

    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.val + "->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}
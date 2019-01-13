class Node {

    private static int nodeNumber = 0;
    public Node next;
    public int val;

    public Node() {
        this.val = nodeNumber++;
        this.next = null;
    }
}

public class Stack {

    private Node head;
    private Node tail;

    public void push() {
        if(head == null) {
            head = new Node();
            tail = head;
        }
        else {
            tail.next = new Node();
            tail = tail.next;
        }
    }

    public void pop() {
        if(head == null) { //has nothing
            System.out.println("Nothing in list, can't pop");
        }
        else if(head.next == null) { //has one thing
            head = null;
        }
        else { //has many things
            //run to the one right before tail
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
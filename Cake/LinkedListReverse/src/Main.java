class LinkedListNode {

    public static int nodeNumber = 0;
    public int value;
    public LinkedListNode next;

    public LinkedListNode() {
        this.value = nodeNumber++;
    }

    public void print() {
        LinkedListNode traverse = this;
        while(traverse != null) {
            System.out.print("->" + traverse.value);
            traverse = traverse.next;
        }
        System.out.println("->NULL");
    }
}

public class Main {

    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode();
        LinkedListNode b = new LinkedListNode();
        LinkedListNode c = new LinkedListNode();
        LinkedListNode d = new LinkedListNode();
        LinkedListNode e = new LinkedListNode();
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        a.print();
        reverseLinkedList(a).print();
        reverseLinkedList(null); //test for empty list
        reverseLinkedList(new LinkedListNode()).print(); //test for list with one element
    }

    public static LinkedListNode reverseLinkedList(LinkedListNode head) {
        if(head == null) {
            System.out.println("Need to pass in a valid list");
            return null;
        }
        LinkedListNode lead, middle, follow;
        lead = head.next;
        middle = head;
        follow = null;
        while(middle != null) {
            middle.next = follow;
            follow = middle;
            middle = lead;
            if(lead != null) {
                lead = lead.next;
            }
        }
        return follow;
    }
}

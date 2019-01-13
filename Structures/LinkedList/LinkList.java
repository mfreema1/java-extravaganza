class Node {

    private static int upperVal = 0;
    public int val;
    public Node next;

    public Node() {
        this.val = upperVal++;
        this.next = null;
    }
}

class LinkList {

    private Node head;

    public void append() {
        if(head == null)
            head = new Node();
        else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;    
            }
            //we are at the end, append
            temp.next = new Node();
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
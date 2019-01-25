class LinkedListNode {

    public String value;
    public LinkedListNode next;

    public LinkedListNode(String value) {
        this.value = value;
    }
}

public class Main {

    public static void main(String[] args) {
        LinkedListNode a = new LinkedListNode("Angel Food");
        LinkedListNode b = new LinkedListNode("Bundt");
        LinkedListNode c = new LinkedListNode("Cheese");
        LinkedListNode d = new LinkedListNode("Devil's Food");
        LinkedListNode e = new LinkedListNode("Eccles");

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        LinkedListNode out = kthToLastNode(2, a);
        if(out != null) {
            System.out.println(out.value);
        }
    }

    public static LinkedListNode kthToLastNode(int number, LinkedListNode head) {
        LinkedListNode lead = head;
        LinkedListNode follow = head;
        //create an offset between the two nodes
        for(int i = 0; i < number; i++) {
            if(lead == null) {
                System.out.println("Not enough elements in list");
                return null;
            }
            else {
                lead = lead.next;
            }
        }
        //slide them down the linked list until the leading one falls off
        //the gap we created earlier assures that follow will land on the right node
        while(lead != null) {
            lead = lead.next;
            follow = follow.next;
        }
        return follow;
    }
}

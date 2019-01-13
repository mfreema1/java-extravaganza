import java.util.LinkedList;
import java.util.Queue;

class Node {

    public int data;
    public Node left;
    public Node right;

    public Node(int number) {
        this.data = number;
        this.left = null;
        this.right = null;
    }
}

public class MyBinaryTree {

    private Node head;

    public MyBinaryTree() {

    }

    public void insert(int number) {
        if(head == null) {
            head = new Node(number);
        }
        else {
            Node lead = head, follow = head;
            while(lead != null) {
                follow = lead; //prepare to make a move, advance the trailing pointer
                if(number > lead.data) {
                    //our node is bigger, must go right
                    lead = lead.right;
                }
                else if(number < lead.data) {
                    //our node is smaller, go left
                    lead = lead.left;
                }
            }
            //lead just ran off, now follow holds the position right before it.  One last check
            if(number > follow.data) {
                //go right
                follow.right = new Node(number);
            }
            else if(number < follow.data) {
                //go left
                follow.left = new Node(number);
            }
        }
    }

    public void bfs(int number) {
        if(head == null) {
            System.out.println("Cannot search, empty tree");
        }
        else {
            Queue<Node> queue = new LinkedList<>();
            Node next = head;
            while(next != null) {
                if(next.data == number) {
                    System.out.println("Found the number: " + number);
                    return;
                }
                System.out.println(next.data);
                if(next.left != null)
                    queue.offer(next.left);
                if(next.right != null)
                    queue.offer(next.right);
                next = queue.poll();
            }
            System.out.println("Could not find the number: " + number);
        }
    }

    public void dfs(int number) {
        dfs(head, number);
    }

    public void dfs(Node node, int number) {
        if(node == null) {
            return;
        }
        else {
            if(node.data == number) {
                System.out.println("Found the number: " + number);
                return;
            }
            System.out.println(node.data);
            dfs(node.left, number);
            dfs(node.right, number);
        }
    }

    public void inorder() {
        inorder(head);
    }

    //left root right
    public void inorder(Node node) {
        if(node != null) {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }

    public void preorder() {
        preorder(head);
    }

    //root left right
    public void preorder(Node node) {
        if(node != null) {
            System.out.println(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public void postorder() {
        postorder(head);
    }
    
    public void postorder(Node node) {
        if(node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.data);
        }
    }
}
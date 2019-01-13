public class Main {

    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(7);
        tree.insert(9);
        tree.insert(8);
        tree.insert(6);
    
        tree.inorder();
        System.out.println("---");
        tree.preorder();
        System.out.println("---");
        tree.postorder();
        System.out.println("---");
        tree.bfs(8);
        System.out.println("---");
        tree.dfs(8);                
    }
}
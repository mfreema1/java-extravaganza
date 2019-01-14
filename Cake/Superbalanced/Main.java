import java.util.Set;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Deque;

//taken from https://www.interviewcake.com/question/java/balanced-binary-tree?course=fc1&section=trees-graphs
class BinaryTreeNode {

    public int value;
    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public BinaryTreeNode insertLeft(int leftValue) {
        this.left = new BinaryTreeNode(leftValue);
        return this.left;
    }

    public BinaryTreeNode insertRight(int rightValue) {
        this.right = new BinaryTreeNode(rightValue);
        return this.right;
    }
}

//partially my code, but mostly their code as well.  I looked at the solution.
class NodeDepthPair {
    
    public BinaryTreeNode node;
    public int depth;

    public NodeDepthPair(BinaryTreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

public class Main {

    public static void main(String[] args) {
        BinaryTreeNode superbalanced = new BinaryTreeNode(5);
        superbalanced.insertLeft(3).insertLeft(2);
        superbalanced.insertRight(6).insertRight(7).insertRight(8);
        
        BinaryTreeNode nonsuperbalanced = new BinaryTreeNode(5);
        nonsuperbalanced.insertLeft(4);
        nonsuperbalanced.insertRight(6).insertRight(7).insertRight(8);

        System.out.println("Super balanced tree: " + isSuperBalanced(superbalanced));
        System.out.println("Non-super balanced tree: " + isSuperBalanced(nonsuperbalanced));
    }

    public static boolean isSuperBalanced(BinaryTreeNode head) {
        Deque<NodeDepthPair> searchStack = new ArrayDeque<>();
        Set<Integer> depthSet = new HashSet<>();

        //perform an iterative dfs of the tree, assume the head passed in isn't null
        //1. add the head
        searchStack.push(new NodeDepthPair(head, 0));
        
        //2. run the actual dfs now that we have initial values
        while(!searchStack.isEmpty()) {
            NodeDepthPair pair = searchStack.pop();
            BinaryTreeNode node = pair.node;
            //if the node has no left or right children, it is a leaf, record its depth
            if(node.left == null && node.right == null) {
                depthSet.add(pair.depth);
            }
            if(node.left != null)
                searchStack.push(new NodeDepthPair(node.left, pair.depth + 1));
            if(node.right != null)
                searchStack.push(new NodeDepthPair(node.right, pair.depth + 1));
        }

        //3. could short circuit by checking this in the while loop, but if the set size ever gets to
        //three, then there is no way it can be super-balanced.  If we have 2 leaf depths, then we must check to
        //see that they are only one apart at most
        if(depthSet.size() > 2)
            return false;
        if(depthSet.size() == 2) {
            List<Integer> depthSetAsList = new ArrayList<>(depthSet);
            if(Math.abs(depthSetAsList.get(0) - depthSetAsList.get(1)) > 1)
                return false;
        }
        return true;
    }
}
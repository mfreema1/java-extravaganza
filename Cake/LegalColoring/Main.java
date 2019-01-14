import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

    }

    //borrowed heavily from https://www.interviewcake.com/question/java/graph-coloring
    public static void color(GraphNode[] nodes, String[] colors) {
        for(GraphNode node : nodes) {
            //get the illegal colors first so that we can pick a good color
            Set<GraphNode> neighbors = node.getNeighbors();
            Set<String> illegalColors = new HashSet<>();
            for(GraphNode neighbor : neighbors) {
                if(neighbor.hasColor()) {
                    illegalColors.add(neighbor.getColor);
                }
            }

            //try a color until we get one that is legal
            for(String color : colors) {
                if(!illegalColors.contains(color)) {
                    node.setColor(color);
                    break;
                }
            }
        }
    }
}
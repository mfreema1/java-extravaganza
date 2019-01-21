import java.util.HashMap;
import java.util.Map;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

class NodePathPair {

    List<String> path;
    String node;

    public NodePathPair(List<String> path, String node) {
        this.path = path;
        this.node = node;
    }
}

public class Main {

    public static void main(String[] args) {
        Map<String, String[]> network = new HashMap<String, String[]>() {{
            put("Min",     new String[] { "William", "Jayden", "Omar" });
            put("William", new String[] { "Min", "Noam" });
            put("Jayden",  new String[] { "Min", "Amelia", "Ren", "Noam" });
            put("Ren",     new String[] { "Jayden", "Omar" });
            put("Amelia",  new String[] { "Jayden", "Adam", "Miguel" });
            put("Adam",    new String[] { "Amelia", "Miguel", "Sofia", "Lucas" });
            put("Miguel",  new String[] { "Amelia", "Adam", "Liam", "Nathan" });
            put("Noam",    new String[] { "Nathan", "Jayden", "William" });
            put("Omar",    new String[] { "Ren", "Min", "Scott" });
            put("Roger",   new String[] { "Melanie" });
        }};
        String[] out = MeshMessage(network, "Jayden", "Jayden");
        if(out != null) {
            System.out.println(Arrays.toString(out));
        }
    }

    public static String[] MeshMessage(Map<String, String[]> network, String from, String to) {
        //sending a message to yourself, don't even do bfs
        if(from.equals(to)) {
            return new String[] { from };
        }

        List<String> people = new ArrayList<>();
        people.add(from);
        NodePathPair firstPerson = new NodePathPair(people, from);

        //run bfs
        Deque<NodePathPair> peopleToProcess = new ArrayDeque<>();
        peopleToProcess.offer(firstPerson);

        //make sure to keep track of who we visited to avoid cycles
        Set<String> visited = new HashSet<>();

        while(!peopleToProcess.isEmpty()) {
            NodePathPair person = peopleToProcess.poll();
            String[] peopleCanReach = network.get(person.node);
            if(peopleCanReach != null) { //if we know them on the network
                for(String p : peopleCanReach) {
                    if(p.equals(to)) {
                        person.path.add(p);
                        String[] out = new String[person.path.size()];
                        out = person.path.toArray(out);
                        return out;
                    }
                    if(!visited.contains(p)) {
                        List<String> newPath = new ArrayList<>(person.path);
                        newPath.add(p);
                        peopleToProcess.offer(new NodePathPair(newPath, p));
                        visited.add(p);
                    }
                }
            }
        }
        System.out.println("Could not find path connecting nodes");
        return null;
    }
}
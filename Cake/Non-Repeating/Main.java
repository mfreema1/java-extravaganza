import java.util.Map;
import java.util.LinkedHashMap;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        KthNonRepeat("aabbbcd", 1);
        KthNonRepeat("aabbbcd", 2);
        KthNonRepeat("aabbbcd", 3);
        KthNonRepeat("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", 1);
    }

    public static void KthNonRepeat(String s, int k) {
        Map<Character, ArrayList<Integer>> dictionary = new LinkedHashMap<>();
        //PHASE 1: Fill up a dictionary with all of the positions of the letters
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i); 
            if(!dictionary.containsKey(c)) {
                //start the list
                dictionary.put(c, new ArrayList<Integer>());
                dictionary.get(c).add(i);
            }
            else {
                //add to the list
                dictionary.get(c).add(i);
            }
        }
        //System.out.println(dictionary);

        //PHASE 2: Go down the dictionary and find which has the lowest position
        int cnt = 0;
        for(Character c : dictionary.keySet()) {
            if(dictionary.get(c).size() > 1)
                continue;
            else {
                if(++cnt == k) {
                    System.out.println(c);
                    return;
                }
            }
        }
        System.out.println("Not that many repeating digits");
    }
}
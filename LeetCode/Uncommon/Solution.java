import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Solution {

    public String uncommonFromSentences(String A, String B) {

        Set<String> wordsA = new HashSet<>();
        for(String word : A.split(" ")) {
            wordsA.add(word);
        }

        Set<String> wordsB = new HashSet<>();
        for(String word : B.split(" ")) {
            wordsB.add(word);
        }

        Set<String> copyOfA = new HashSet<>(wordsA);
        Set<String> uncommon = new HashSet<>();
        copyOfA.removeAll(wordsB);
        wordsB.removeAll(wordsA);
        uncommon.addAll(copyOfA);
        uncommon.addAll(wordsB);

        return Arrays.toString(uncommon.toArray(new String[uncommon.size()]));
    }
}
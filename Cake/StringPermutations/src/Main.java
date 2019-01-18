import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println(stringPermutations("cat"));
    }

    public static Set<String> stringPermutations(String buildup, String s) {
        if(s.length() == 1) {
            return new HashSet<String>(){{ add(buildup + s); }};
        }
        else {
            Set<String> out = new HashSet<>();
            for(int i = 0; i < s.length(); i++) {
                String newString = s.substring(0, i) + s.substring(i + 1);
                out.addAll(stringPermutations(buildup + s.charAt(i), newString));
            }
            return out;
        }
    }

    public static Set<String> stringPermutations(String s) {
        return stringPermutations("", s);
    }
}

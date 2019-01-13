import java.util.Map;
import java.util.HashMap;

class Solution {

    public boolean judgeCircle(String moves) {
        Map<String, Integer> m = new HashMap<>();
        m.put("X", 0);
        m.put("Y", 0);
        
        for(char move : moves.toCharArray()) {
            switch(move) {
                case 'U':
                    m.put("Y", m.get("Y") + 1);
                    break;
                case 'D':
                    m.put("Y", m.get("Y") - 1);
                    break;
                case 'R':
                    m.put("X", m.get("X") + 1);
                    break;
                case 'L':
                    m.put("X", m.get("X") - 1);
                    break;
            }
        }
        
        for(Integer i : m.values()) {
            if(i != 0)
                return false;
        }
        
        return true;
    }
}
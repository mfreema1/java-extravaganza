import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        System.out.println("Make change: " + makeChange(8, new int[]{1, 2, 3}) + ", total calls: " + makeChangeCalls);
        System.out.println("Make change memo: " + makeChangeMemoized(8, new int[] {1, 2, 3}) + ", total calls: " + makeChangeMemoizedCalls);
        System.out.println("Make change bottom up: " + makeChangeBottomUp(4, new int[] {1, 2, 3}));
    }

    private static int makeChangeCalls = 0;
    public static int makeChange(int amountInCents, int[] coins) {
        makeChangeCalls++;
        if(amountInCents == 0) {
            return 1;
        }
        if(coins.length == 0 || amountInCents < 0) {
            return 0;
        }
        else {
            //perform the use-it or lose-it
            int useIt = makeChange(amountInCents - coins[0], coins);
            int loseIt = makeChange(amountInCents, Arrays.copyOfRange(coins, 1, coins.length));
            return useIt + loseIt;
        }
    }

    //need to use a fairly sophisticated map that encapsulates both input variables in the key
    private static Map<String, Integer> knownWaysToMakeChange = new HashMap<>();
    private static int makeChangeMemoizedCalls = 0;
    public static int makeChangeMemoized(int amountInCents, int[] coins) {
        String serializedVars = amountInCents + " with " + Arrays.toString(coins);
        if(knownWaysToMakeChange.get(serializedVars) != null) {
            return  knownWaysToMakeChange.get(serializedVars);
        }
        else {
            makeChangeMemoizedCalls++;
            if(amountInCents == 0) {
                return 1;
            }
            if(coins.length == 0 || amountInCents < 0) {
                return 0;
            }
            else {
                //perform the use-it or lose-it
                int useIt = makeChangeMemoized(amountInCents - coins[0], coins);
                int loseIt = makeChangeMemoized(amountInCents, Arrays.copyOfRange(coins, 1, coins.length));
                int total = useIt + loseIt;
                knownWaysToMakeChange.put(serializedVars, total);
                return total;
            }
        }
    }

    public static int makeChangeBottomUp(int amountInCents, int[] coins) {
        int[][] bottomUpMatrix = new int[coins.length + 1][amountInCents + 1];
        //fill up the first row with all zeros
        for(int i = 1; i < bottomUpMatrix[0].length; i++) {
            bottomUpMatrix[0][i] = 0;
        }

        //fill up the first column with all ones
        for(int i = 1; i < bottomUpMatrix.length; i++) {
            bottomUpMatrix[i][0] = 1;
        }

        for(int i = 1; i < bottomUpMatrix.length; i++) {
            int newCoin = coins[i - 1];
            for (int j = 1; j < bottomUpMatrix[0].length; j++) {
                if (newCoin <= j) {
                    //the new coin fits, it is the one above, plus the one newcoin to the left
                    bottomUpMatrix[i][j] = bottomUpMatrix[i - 1][j] + bottomUpMatrix[i][j - newCoin];
                } else {
                    //no new fit
                    bottomUpMatrix[i][j] = bottomUpMatrix[i - 1][j];
                }
            }
        }
        System.out.println(Arrays.deepToString(bottomUpMatrix));
        return bottomUpMatrix[coins.length][amountInCents];
    }
}

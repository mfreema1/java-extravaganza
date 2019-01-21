import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class CakeType {
    public int weight;
    public int value;

    public CakeType(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}

public class Main {

    public static void main(String[] args) {
        CakeType[] cakes = new CakeType[] {
                new CakeType(7, 160),
                new CakeType(3, 90),
                new CakeType(2, 15)
        };
        System.out.println("Brute force: " + maxDuffelBagValueBruteForce(cakes, 20) + ", total calls: " + maxDuffelBagValueBruteForceCalls);
        System.out.println("Top down: " + maxDuffelBagValueTopDown(cakes, 20) + ", total calls: " + maxDuffelBagValueTopDownCalls);
        System.out.println("Bottom up: " + maxDuffelBagValueOtherApproach(cakes, 20));
    }

    private static int maxDuffelBagValueBruteForceCalls = 0;
    public static int maxDuffelBagValueBruteForce(CakeType[] cakes, int weight) {
        //use it or lose it approach with recursion
        if(weight == 0 || cakes.length == 0) {
            return 0;
        }
        //record the call
        maxDuffelBagValueBruteForceCalls++;
        //can't take the first item, must lose it
        if(cakes[0].weight > weight) {
            return maxDuffelBagValueBruteForce(Arrays.copyOfRange(cakes, 1, cakes.length), weight);
        }
        else {
            //recall that the queen has an unlimited supply of each cake, so we do not remove it from the array upon using
            int useIt = cakes[0].value + maxDuffelBagValueBruteForce(cakes, weight - cakes[0].weight);
            int loseIt = maxDuffelBagValueBruteForce(Arrays.copyOfRange(cakes, 1, cakes.length), weight);
            return Math.max(useIt, loseIt);
        }
    }

    private static Map<String, Integer> cakeValues = new HashMap<>();
    private static int maxDuffelBagValueTopDownCalls = 0;
    public static int maxDuffelBagValueTopDown(CakeType[] cakes, int weight) {
        if(weight == 0 || cakes.length == 0) {
            return 0;
        }
        //make a way to retrieve all variables from the map
        String signature = weight + " with " + Arrays.toString(cakes);
        //if our best guess is in the map, go get it
        if(cakeValues.get(signature) != null) {
            return cakeValues.get(signature);
        }
        //map missed, record the call
        maxDuffelBagValueTopDownCalls++;
        if(cakes[0].weight > weight) {
            int maximum = maxDuffelBagValueTopDown(Arrays.copyOfRange(cakes, 1, cakes.length), weight);
            cakeValues.put(signature, maximum);
            return maximum;
        }
        else {
            int useIt = cakes[0].value + maxDuffelBagValueTopDown(cakes, weight - cakes[0].weight);
            int loseIt = maxDuffelBagValueTopDown(Arrays.copyOfRange(cakes, 1, cakes.length), weight);
            int maximum = Math.max(useIt, loseIt);
            cakeValues.put(signature, maximum);
            return maximum;
        }
    }

    public static int maxDuffelBagValueOtherApproach(CakeType[] cakes, int weight) {
        int[] bestGuessesForWeights = new int[weight + 1];

        for(int i = 1; i < bestGuessesForWeights.length; i++) {
            //set up a variable to get the max possible given each new weight
            int tempMax = 0;
            for (CakeType cake : cakes) {
                if(cake.weight <= i) {
                    //take the cake and compare it to our best guess
                    int guessWithTakingCake = cake.value + bestGuessesForWeights[i - cake.weight];
                    tempMax = Math.max(guessWithTakingCake, tempMax);
                }
            }
            bestGuessesForWeights[i] = tempMax;
        }
        return bestGuessesForWeights[weight];
    }

//    public static int maxDuffelBagValueBottomUp(CakeType[] cakes, int weight) {
//        int[][] guessMatrix = new int[cakes.length + 1][weight + 1];
//        //fill in the first row with all zeros
//        for(int i = 0; i < guessMatrix[0].length; i++) {
//            guessMatrix[0][i] = 0;
//        }
//        //fill in the first column with all zeros
//        for(int i = 0; i < guessMatrix.length; i++) {
//            guessMatrix[i][0] = 0;
//        }
//        //now go through and build up our best guesses
//        //oh wait, this method works for when we don't have infinite supply of an item...
//        //how might we change this to support that?
//    }
}

public class Main {

    public static void main(String[] args) {
        System.out.println(largestMonotonous(124567));
        System.out.println(largestMonotonous(6781567));
    }

    public static int getCliffIndex(Integer N) {
        String integerAsString = N.toString();
        int lastIntegerAtPosition = -1;
        //keep track of the number of repeating digits you found.  For cases such as 668841, this is important.
        //for this case you would want to return 667999.  Notice that the cliff index is the number of repeats before
        //the original cliff
        int numRepeats = 0;
        for(int i = 0; i < integerAsString.length(); i++) {
            int integerAtPosition = Character.getNumericValue(integerAsString.charAt(i));
            if(integerAtPosition < lastIntegerAtPosition)
                return i - numRepeats;
            else {
                if(integerAtPosition == lastIntegerAtPosition)
                    numRepeats++;
                else
                    numRepeats = 0;
                lastIntegerAtPosition = integerAtPosition;
            }
        }
        //was already monotonous, return -1 to signal
        return -1;
    }

    public static int largestMonotonous(Integer N) {
        //get to one before the cliff index.  Reduce this by one and then fill out with 9's
        int cliffIndex = getCliffIndex(N);
        if(cliffIndex == -1) //already monotonous
            return N;
        String integerAsString = N.toString();
        StringBuilder sb = new StringBuilder();
        int integerToAppend;
        for(int i = 0; i < integerAsString.length(); i++) {
            if(i == cliffIndex - 1) //this is the one we decrement by one and tack onto the string
                integerToAppend = Character.getNumericValue(integerAsString.charAt(i)) - 1;
            else if(i < cliffIndex - 1) //simply copy over
                integerToAppend = Character.getNumericValue(integerAsString.charAt(i));
            else //copy over 9's
                integerToAppend = 9;
            sb.append(integerToAppend);
        }
        return Integer.parseInt(sb.toString());
    }
}

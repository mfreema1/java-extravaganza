public class Main {

    public static void main(String[] args) {

        //make an empty array of 10 variables
        int[] myVars = new int[10];

        //you could go through like this and assign values
        //myVars[0] = 10;
        //myVars[1] = 20;

        //but that's tedious.  There's a shortcut
        int[] myShortcutArr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        //could also loop and use i to access
        int cnt = 10;
        for(int i = 0; i < myVars.length; i++,cnt += 10) {
            myVars[i] = cnt;
        }

        printArr(myVars);
    }

    public static void printArr(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
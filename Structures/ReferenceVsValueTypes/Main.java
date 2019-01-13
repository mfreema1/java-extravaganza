import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int val = 10;
        int anotherVal = val;

        anotherVal = 20; //note that val does not change

        System.out.println(val);
        System.out.println(anotherVal);

        //arrays are reference types.  Here, 'arr' is a reference
        //to the array in memory

        //when something is a reference type, it hands back the address
        //of the variable, rather than the data itself. You then work
        //on the object in memory using the address
        int[] arr = new int[5];
        int[] anotherArr = arr; //these are now BOTH references to the same array

        anotherArr[0] = 10; //note that arr DOES change

        //Arrays.toString takes any iterable and loops over it,
        //separating the elements with a comma
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(anotherArr));
    }
}
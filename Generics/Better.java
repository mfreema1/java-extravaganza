import java.util.ArrayList;

public class Better {

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<Integer>();
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5); 
    }

    //now we have type safety, as we can rest assured that everything
    //in the arraylist is of type integer.
    public static void printDouble(Arraylist<Integer> lst) {
        for(int i : lst) {
            System.out.println(i * 2);
        }
    }
}
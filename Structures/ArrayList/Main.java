import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    //Arraylists are dynamic in size.  They will hold a set amount
    //of items, and then once capacity is reached, they will copy 
    //everything over to a bigger array.  The insert that does this is
    //hence O(N) time.

    //Typically they will double in size everytime.  So, each time you
    //do this, it gets twice as large, but you also do it twice as
    //infrequently.
    public static void main(String[] args) {

        GroceryList list = new GroceryList();
        list.addItem("Carrots");
        list.addItem("Mushrooms");
        list.addItem("Bananas");

        list.print();
    }
}
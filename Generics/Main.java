import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList data = new ArrayList(); //not using the generic syntax
        data.add(1);
        data.add(2);
        data.add(3);
        data.add(4);
        data.add(5);        
    }

    //this is the old way of doing things before Java 1.5.  As you can see,
    //it's unsafe, as you subvert the type checking that Java uses.
    public static void printDouble(Arraylist lst) {
        for(Object i : lst) {
            System.out.println((Integer) i * 2);
        }
    }
}
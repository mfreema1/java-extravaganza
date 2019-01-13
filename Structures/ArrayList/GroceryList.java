import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceries = new ArrayList<String>();
    
    public void addItem(String item) {
        groceries.add(item);
    }

    public void print() {
        for(int i = 0; i < groceries.size(); i++) {
            System.out.println(groceries.get(i));
        }
    }
}
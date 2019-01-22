import java.util.Stack;

//a stack that will return the max of the stack in O(1) time always
public class MyStack extends Stack<Integer> {

    private Stack<Integer> maxes;

    public MyStack() {
        super();
        maxes = new Stack<>();
    }

    @Override
    public Integer pop() {
        int item = super.pop();
        if(item == maxes.peek()) {
            maxes.pop();
        }
        return item;
    }

    @Override
    public Integer push(Integer item) {
        super.push(item);
        if(maxes.size() == 0) {
            maxes.push(item);
            return item;
        }
        else {
            int currentMax = maxes.peek();
            if(currentMax <= item) {
                maxes.push(item);
            }
            return item;
        }
    }

    public int getMax() {
        return maxes.peek();
    }
}

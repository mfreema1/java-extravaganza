public class Main {

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println("Max: " + stack.getMax());
        stack.pop();
        System.out.println("Max: " + stack.getMax());
        stack.pop();
        System.out.println("Max: " + stack.getMax());
        stack.pop();
        System.out.println("Max: " + stack.getMax());
        stack.pop();
    }

}

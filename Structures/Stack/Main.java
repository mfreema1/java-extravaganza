public class Main {

    public static void main(String[] args) {

        Stack stack = new Stack();

        for(int i = 0; i < 4; i++) {
            stack.push();
            stack.print();
        }

        for(int i = 0; i < 5; i++) {
            stack.pop();
            stack.print();
        }
    }
}
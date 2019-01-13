public class Main {

    public static void main(String[] args) {

        Queue queue = new Queue();

        for(int i = 0; i < 4; i++) {
            queue.enqueue();
            queue.print();
        }

        for(int i = 0; i < 5; i++) {
            queue.dequeue();
            queue.print();
        }
    }
}
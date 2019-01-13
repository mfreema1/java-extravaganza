public class Main {
    
    public static void main(String[] args) {
        System.out.println(add(5, 5));
        System.out.println(add(5, 5, 5));
    }

    public static int add(int num1, int num2) {
        return num1 + num2;
    }

    public static int add(int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }
}
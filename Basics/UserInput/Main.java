import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //new is used to create an instance of a class
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Enter your year of birth: ");
        int year = scanner.nextInt();

        scanner.close();
        // try {
        //     year = Integer.parseInt(scanner.nextLine());
        // }
        // catch(NumberFormatException e) {
        //     System.out.println("That isn't a number");
        //     year = 0;
        // finally {
        //     scanner.close();
        // }
        // }

        System.out.println("Your name is " + name);
        System.out.println("You are " + (2018 - year) + " years old");
    }
}
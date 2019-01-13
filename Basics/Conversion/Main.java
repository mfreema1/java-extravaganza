public class Main {

    public static void main(String[] args) {
        System.out.println("3 Feet equals: " + convert("Feet", 3));
        System.out.println("3 Meters equals: " + convert("Meters", 3));
        System.out.println("This will fail: " + convert("Inch", 3));
    }

    public static double convert(String from, int amount) {
        if(from.equals("Feet"))
            return amount * 0.3048d;
        else if(from.equals("Meters"))
            return amount * 3.28084d;
        else {
            System.out.println("Not a valid measurement");
            return 0d;
        }
    }

}
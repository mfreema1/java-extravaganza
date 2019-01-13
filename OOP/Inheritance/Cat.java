public class Cat extends Animal {

    private String furColor;
    private int numEyes;
    private String eyeColor;

    public Cat(String name, int weight, String furColor, String eyeColor) {
        super(name, "Meow", weight); //all cats meow
        this.furColor = furColor;
        this.numEyes = 2; //all cats have two eyes
        this.eyeColor = eyeColor;
    }
}
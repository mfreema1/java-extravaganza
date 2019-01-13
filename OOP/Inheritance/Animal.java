public class Animal {

    private String name;
    private String sound;
    private int weight;

    public Animal(String name, String sound, int weight) {
        this.name = name;
        this.sound = sound;
        this.weight = weight;
    }

    public void makeSound() {
        System.out.println(this.sound);
    }
}
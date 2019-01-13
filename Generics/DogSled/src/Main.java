public class Main {

    public static void main(String[] args) {
        System.out.println("Starting to add dogs to the team");
        DogSled dogSled = new DogSled();
        dogSled.addDog(new Dog("Roger"));
        dogSled.addDog(new Dog("Buster"));
        dogSled.addDog(new Dog("Bandit"));
        System.out.println("We have " + dogSled.getTeamSize() + " dogs on the team.");

        //notice that even trying to type this throws a type error -- very type safe
        //System.out.println("Now trying to add a cat to the team");
        //sled.addDog(new Cat(""))

        System.out.println("---");

        //an approach using simply a superclass to provide some logic.  Note that this method does not impose
        //restrictions on what can be added to the sled.  For instance, we can add both a dog AND a cat to this sled
        System.out.println("Now we will make an animal sled.  We will add a dog and cat to this sled");
        AnimalSled animalSled = new AnimalSled();
        animalSled.addAnimal(new Cat("Jerome"));
        animalSled.addAnimal(new Dog("Molly"));
        System.out.println("We have " + animalSled.getTeamSize() + " animals on the team.");

        System.out.println("---");

        //probably the most sophisticated approach of the three.  This approach uses generics to restrict
        //what types of objects can be supplied to the sled and gives us quite a bit of flexibility with how we
        //instantiate it
        System.out.println("Lastly, a sled that can have an animal or any subclass of an animal, such as cats or dogs");
        Sled<Cat> catSled = new Sled<>();
        catSled.addAnimal(new Cat("Mortimer"));
        System.out.println("We now have " + catSled.getTeamSize() + " animals on this sled");
    }
}

import java.util.ArrayList;

public class Sled<T extends Animal> { //bounded type parameter
    //using the "extends Animal" makes sure that only that class or its
    //subclasses can be supplied.  Therefore, if we have logic in the Animal
    //class such as 'getName()' we can now call that from within this class, as
    //we now know we will have it defined.

    //you can include multiple bounds, but they will follow standard inheritance
    //rules.  So, for example, you could not extend from more than one class, however
    //you could extend from multiple interfaces.

    private ArrayList<T> sledTeam;

    public Sled() {
        this.sledTeam = new ArrayList<>();
    }

    public void addAnimal(T animal) {
        sledTeam.add(animal);
        System.out.println(animal.getName() + " added to the sled");
    }

    public int getTeamSize() {
        return sledTeam.size();
    }
}

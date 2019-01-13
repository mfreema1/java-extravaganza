import java.util.ArrayList;

public class AnimalSled {

    ArrayList<Animal> sledTeam;

    public AnimalSled() {
        this.sledTeam = new ArrayList<>();
    }

    public void addAnimal(Animal animal) {
        sledTeam.add(animal);
        System.out.println("Added " + animal.getName() + " to the team");
    }

    public int getTeamSize() {
        return sledTeam.size();
    }
}

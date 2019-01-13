import java.util.ArrayList;

public class DogSled {

    private ArrayList<Dog> sledTeam;

    //just to be explicit
    public DogSled() {
        sledTeam = new ArrayList<>(); //Java 1.8 diamonds
    }

    public void addDog(Dog d) {
        sledTeam.add(d);
        System.out.println("Added " + d.getName() + " to the sled");
    }

    public int getTeamSize() {
        return sledTeam.size();
    }
}

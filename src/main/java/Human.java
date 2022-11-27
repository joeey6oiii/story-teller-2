import java.util.ArrayList;

public class Human extends Entity {
    private static ArrayList<Human> humans = new ArrayList<Human>();

    public Human(){
        super.setName("Человек");
    }

    public Human(String name){
        super(name);
    }

    public Human(String name, Place location){
        super(name, location);
    }

    public static void addHuman(Human ... human){
        for(Human homosap : human){
            humans.add(homosap);
        }
    }
}

import java.util.ArrayList;

public class They extends Entity implements CanFind {
    private ArrayList<Entity> people = new ArrayList<>();

    public They(Entity ... people){
        for(Entity entity : people){
            this.people.add(entity);
        }
    }

    public void addPeople(Entity ... people){
        for(Entity entity : people){
            this.people.add(entity);
        }
    }

    public void findPlace(Place location){
        System.out.println(this.toString() + " нашли " + location.getName());
    }

    public void findItem(Item item){
        System.out.println(this.toString() + " нашли " + item.getName());
    }

    @Override
    public void setLocation(Place location){
        super.setLocation(location);
        for(Entity entity : people){
            entity.setLocation(location);
        }
    }

    @Override
    public String toString(){
        switch(people.size()){
            case 0: return "TheyIsEmpty";
            case 1: return people.get(0).getName();
            case 2: return people.get(0).getName() + " и " +
                    people.get(1).getName();
            default:
                String temp = "";
                for(int i = 0; i < people.size() - 1; i++){
                    temp += people.get(i).getName() + ", ";
                }
                temp = temp.substring(0, temp.length() - 2);
                temp += " и " + people.get(people.size() - 1).getName();
                return temp;
        }
    }
}

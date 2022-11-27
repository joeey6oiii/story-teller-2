import java.util.ArrayList;
import java.util.Objects;

public abstract class Entity {
    private String name;
    private Place location;
    private ArrayList<Item> items = new ArrayList<>();

    public Entity(){}

    public Entity(String name){
        this.name = name;
    }

    public Entity(String name, Place location){
        this.name = name;
        this.location = location;
    }

    public String getName(){
        return name;
    }

    public Place getLocation(){
        return location;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLocation(Place location){
        this.location = location;
    }

    public ArrayList<Item> getItemsList(){
        return items;
    }

    public void setItems(Item... items){
        for(Item item : items){
            this.items.add(item);
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;

        if (obj == null || obj.getClass() != this.getClass()) return false;

        Entity other = (Entity) obj;

        return name.equals(other.name) && location.equals(other.location);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, location);
    }

    @Override
    public String toString(){
        return getClass().getName() + "[" + "name=" + this.name +
                ",location=" + this.location + "]";
    }
}

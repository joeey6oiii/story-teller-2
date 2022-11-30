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

    public void setItems(Item... items){
        for(Item item : items){
            this.items.add(item);
        }
    }

    public Item getItemUsingIndex(int index){
        return items.get(index);
    }

//    public Item getItemUsingId(int id){
//        int index = 0;
//        for (Item it : items) {
//            if (it.getId() == id) {
//                index = items.indexOf(it);
//            }
//        }
//        return items.get(index);
//    }

    public Item[] getItems(){
        return this.items.toArray(new Item[this.items.size()]);
    }

    public void addItem(Item ... item) {
        for(Item it : item){
            this.items.add(it);
        }
    }

    public void removeItem(Item ... items){
        for(Item it : items){
            this.items.remove(it);
        }
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(name, entity.name) &&
                Objects.equals(location, entity.location) && Objects.equals(items, entity.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, items);
    }
}

import java.util.ArrayList;

public class Shelf extends Item implements CanTakePut {
    private ArrayList<Item> items = new ArrayList<>();

    public Shelf(String name) {
        super(name);
    }

    public void addItems(Item ... items) {
        for(Item item : items){
            this.items.add(item);
        }
    }

    public ArrayList<Item> getItems(){
        return items;
    }
}

package items;

import interfaces.*;

import java.util.ArrayList;
import java.util.Objects;

public class Shelf extends Item implements TakePutAble {
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

    @Override
    public String toString() {
        return "Shelf{" +
                "items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Shelf shelf = (Shelf) o;
        return Objects.equals(items, shelf.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), items);
    }
}

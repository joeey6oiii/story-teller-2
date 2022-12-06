package items;

import interfaces.IsOpenable;

import java.util.ArrayList;
import java.util.Objects;

public class Cabinet extends Item implements IsOpenable {
    private ArrayList<Shelf> shelves = new ArrayList<>();
    private boolean isOpen = false;

    public Cabinet(String name) {
        super(name);
    }

    public void setShelves(Shelf... shelves) {
        for(Shelf shelf : shelves){
            this.shelves.add(shelf);
        }
    }

    public void addShelf(Shelf shelf) {
        this.shelves.add(shelf);
    }

    public Shelf getShelf(int index){
        return shelves.get(index);
    }

    public void setOpen(boolean opened) {
        this.isOpen = opened;
    }

    public boolean getOpen() {
        return isOpen;
    }

    @Override
    public String toString() {
        return "Cabinet{" +
                "shelves=" + shelves +
                ", isOpen=" + isOpen +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cabinet cabinet = (Cabinet) o;
        return isOpen == cabinet.isOpen && Objects.equals(shelves, cabinet.shelves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), shelves, isOpen);
    }
}

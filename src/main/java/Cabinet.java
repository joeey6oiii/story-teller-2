import java.util.ArrayList;

public class Cabinet extends Item implements CanBeOpened {
    private ArrayList<Shelf> shelves = new ArrayList<>();

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
}

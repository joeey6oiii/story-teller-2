package places;

import items.*;

import java.util.*;

public class Canteen extends Place {
    private ArrayList<Meal> meals = new ArrayList<>();
    private HashMap<Integer, Item> items = new HashMap<>();

    public Canteen(String name){
        super(name);
    }

    public void setMeals(Meal ... meals){
        this.meals.addAll(Arrays.asList(meals));
    }

    public ArrayList<Meal> getMeals(){
        return meals;
    }

    public void addMeals(Meal ... meal){
        Collections.addAll(Arrays.asList(meal));
    }

    public void removeMeals(Meal ... meal){
        meals.removeAll(Arrays.asList(meal));
    }

    public Meal randomMeal(){
        return meals.get(new Random().nextInt(meals.size()));
    }

    public void setItems(Item ... items){
        for (int i = 0; i < items.length; i++){
            this.items.put(i, items[i]);
        }
    }

    public void addItems(Item ... items){
        for (Item item : items) {
            this.items.put(this.items.size(), item);
        }
    }

    public void removeItem(int hash, Item item){
        items.remove(hash, item);
    }


    public Item getItemUsingHashKey(int key){
        return items.get(key);
    }

    @Override
    public String toString() {
        return "Canteen{" +
                "meals=" + meals +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Canteen canteen = (Canteen) o;
        return Objects.equals(meals, canteen.meals) && Objects.equals(items, canteen.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), meals, items);
    }
}
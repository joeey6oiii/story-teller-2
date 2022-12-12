package places;

import interfaces.*;
import items.*;

import java.util.*;

public class Canteen extends Place implements ItemsCheckable {
    ArrayList<Meal> meals = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();

    public Canteen(String name){
        super(name);
    }

    public void setMeals(Meal ... meals){
        this.meals.addAll(Arrays.asList(meals));
    }

    public Meal[] getMeals(){
        return meals.toArray(new Meal[meals.size()]);
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

    public void getItems(){
        String temp = "";
        for(Item item : items){
            temp += item.getName() + ", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        System.out.println("В " + this.getName() + " есть " + temp);
    }

    @Override
    public String toString() {
        return "Canteen{" +
                "meals=" + meals +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Canteen canteen = (Canteen) o;
        return Objects.equals(meals, canteen.meals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), meals);
    }
}
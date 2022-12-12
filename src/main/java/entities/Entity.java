package entities;

import items.*;
import places.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        Collections.addAll(this.items, items);
    }

    public Item getItemUsingIndex(int index){
        return items.get(index);
    }

    public Item[] getItems(){
        return this.items.toArray(new Item[this.items.size()]);
    }

    public void addItem(Item... item) {
        this.items.addAll(Arrays.asList(item));
    }

    public void removeItem(Item... items){
        for(Item it : items){
            this.items.remove(it);
        }
    }

    @Override
    public String toString() {
        return "entities.Entity{" +
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

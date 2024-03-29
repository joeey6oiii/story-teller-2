package entities;

import enums.*;
import interfaces.*;
import items.*;
import places.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public abstract class Entity implements Similarable, ConsumeAble {
    private String name;
    private Place location;
    private ArrayList<Item> items;
    private ArrayList<Status> statuses;

    {
        name = "Default Entity";
        location = new DefaultLocation("Default Location");
        items = new ArrayList<>();
        statuses = new ArrayList<>();
    }

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

    public ArrayList<Item> getItems(){
        return items;
    }

    public void addItem(Item... item) {
        this.items.addAll(Arrays.asList(item));
    }

    public void removeItem(Item... items){
        for(Item it : items){
            this.items.remove(it);
        }
    }

    public void setStatuses(Status... statuses){
        Collections.addAll(this.statuses, statuses);
    }

    public void addStatuses(Status... statuses){
        Collections.addAll(this.statuses, statuses);
    }

    public ArrayList<Status> getStatuses(){
        return statuses;
    }

    public void removeStatuses(Status... statuses){
        for(Status st : statuses){
            this.statuses.remove(st);
        }
    }

    public void consume(IsConsumable... consumables) {
        StringBuilder sb = new StringBuilder();
        for(IsConsumable consumable : consumables){
            sb.append(consumable.getName()).append(", ");
        }
        if(sb.length() > 0){
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
            System.out.println(getName() + " использовал " + sb);
        }
        else{
            System.out.println(getName() + " ничего не использовал");
        }
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", location=" + location +
                ", items=" + items +
                ", statuses=" + statuses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(name, entity.name) && Objects.equals(location, entity.location)
                && Objects.equals(items, entity.items) && Objects.equals(statuses, entity.statuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, items, statuses);
    }
}

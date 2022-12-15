package entities;

import enums.*;
import exceptions.unchecked.IncorrectObject;
import interfaces.*;
import items.*;
import places.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public abstract class Entity implements Similarable {
    private String name;
    private Place location;
    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<Status> statuses = new ArrayList<>();

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

    public void setStatuses(Status... statuses){
        Collections.addAll(this.statuses, statuses);
    }

    public void addStatuses(Status... statuses){
        Collections.addAll(this.statuses, statuses);
    }

    public Status[] getStatuses(){
        return this.statuses.toArray(new Status[this.statuses.size()]);
    }

    public void removeStatuses(Status... statuses){
        for(Status st : statuses){
            this.statuses.remove(st);
        }
    }

    public void similar(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        if(!(object instanceof Entity)) {
            throw new IncorrectObject("Невозможно сравнить объекты разных типов: "
                    + this.getClass().getName() + " и " + object.getClass().getName());
        }
        else {
            if (this.getName().equals(((Entity) object).getName())) {
                stringBuilder.append(((Entity) object).getName()).append(", ");
            }
            if(this.getLocation().equals(((Entity) object).getLocation())){
                stringBuilder.append(((Entity) object).getLocation().getName()).append(", ");
            }
            if(Arrays.equals(this.getItems(), ((Entity) object).getItems())){
                stringBuilder.append(Arrays.toString(((Entity) object).getItems())).append(", ");
            }
            if(Arrays.equals(this.getStatuses(), ((Entity) object).getStatuses())){
                stringBuilder.append(Arrays.toString(((Entity) object).getStatuses())).append(", ");
            }
            if(stringBuilder.length() > 0){
                stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - 2));
                System.out.println(this.getName() +  " похож на " +
                        ((Entity) object).getName() + " по следующим параметрам: " + stringBuilder);
            }
            else {
                System.out.println(this.getName() + " не похож на " + ((Entity) object).getName());
            }
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
        return Objects.equals(name, entity.name) && Objects.equals(location, entity.location) && Objects.equals(items, entity.items) && Objects.equals(statuses, entity.statuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, location, items, statuses);
    }
}

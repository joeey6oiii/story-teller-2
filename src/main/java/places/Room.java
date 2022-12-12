package places;

import interfaces.*;
import items.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Room extends Place implements ItemsCheckable, ReplaceItemsAble {
    private long RoomCost = 0;
    private int id;
    private Place location;
    private ArrayList<Item> items = new ArrayList<>();

    public Room(){
        super.setName("Безымянная комната");
    }

    public Room(String name){
        super(name);
    }

    public Room(String name, int id){
        super(name);
        this.id = id;
    }

    public long getRoomCost(){
        return RoomCost;
    }

    public void setRoomCost(long RoomCost){
        this.RoomCost = RoomCost;
    }

    public int getId() {
        return id;
    }

    public void getItems() {
        System.out.println("В " + this.getName() + " есть " + this.getItemsNames());
    }

    public Place getRoomPlace() {
        return location;
    }

    public void setRoomPlace(Place location) {
        this.location = location;
    }

    public void setItems(Item... items){
        Collections.addAll(this.items, items);
    }

    public void addItems(Item... items){
        Collections.addAll(this.items, items);
    }

    public void replaceItem(IsReplaceable itemToReplace, IsReplaceable itemForReplace) {
        boolean notReplaced = true;
        for(Item item : this.items) {
            if (item.equals(itemToReplace)) {
                if(notReplaced){
                    items.remove(item);
                    items.add((Item) itemForReplace);
                    notReplaced = false;
                    System.out.println("Вместо " + itemToReplace.getName() +
                            " появился " + itemForReplace.getName());
                }
            }
        }
        if(notReplaced){
            System.out.println("Не удалось заменить " + itemToReplace.getName() +
                    " на " + itemForReplace.getName());
        }
    }

    public String getItemsNames(){
        String temp = "";
        for(int i = 0; i < items.size() - 1; i++){
            temp += items.get(i).getName() + ", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        temp += " и " + items.get(items.size() - 1).getName();
        return temp;
    }

    @Override
    public String toString() {
        return "Room{" +
                "RoomCost=" + RoomCost +
                ", id=" + id +
                ", location=" + location +
                ", items=" + items +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return RoomCost == room.RoomCost && id == room.id
                && Objects.equals(location, room.location)
                && Objects.equals(items, room.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), RoomCost, id, location, items);
    }
}
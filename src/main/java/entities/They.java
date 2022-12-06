package entities;

import interfaces.*;
import items.*;
import places.*;

import java.util.ArrayList;
import java.util.Objects;

public class They implements TryAble, FindAble, GoAble, OpenAble,
        ReadAble, PayToGetAble, SeeAble, NoticeAble, WantRestAble {
    private ArrayList<Entity> people = new ArrayList<>();

    public They(Entity ... people){
        for(Entity entity : people){
            this.people.add(entity);
        }
    }

    public void addPeople(Entity ... people){
        for(Entity entity : people){
            this.people.add(entity);
        }
    }

    public void setLocation(Place location){
        for(Entity entity : people){
            entity.setLocation(location);
        }
    }

    public Entity[] getEntities(){
        return people.toArray(new Entity[people.size()]);
    }

    public void find(IsFindable canBeFind){
        int keys = 0;
        if(canBeFind.getClass().equals(Room.class)){
            for(Entity entity : people){
                for(int i = 0; i < entity.getItems().length; i++){
                    if(entity.getItemUsingIndex(i).getClass().equals(Key.class)) {
                        keys += 1;
                    }
                }
            }
            if(keys == 0){
                System.out.println(this.getNames() + " нашли случайный " + canBeFind.getName());
            }
            else{
                System.out.println(this.getNames() + " нашли " + canBeFind.getName());
            }
        }
    }

    public void read(IsReadable readable) {
        if(this.people.size() == 0){
            System.out.println("Никто не читал " + readable.getName() + ": " + readable.say());
        }
        else{
            System.out.println(this.getNames() + " читали " +
                    readable.getName() + ": " + readable.say());
        }
    }

    public void go(Place location) {
        if(this.people.size() == 0) {
            System.out.println("Никто не шел в " + location.getName());
        }
        else{
            System.out.println(this.getNames() + " шли в " + location.getName());
            this.setLocation(location);
        }
    }

    public void payToGet(Item item) {
        ArrayList<Money> totalMoneyList = new ArrayList<>();
        String temp;
        long totalMoney = 0;
        long temp2;
        for(Entity entity : people){
            for(int i = 0; i < entity.getItems().length; i++){
                if(entity.getItemUsingIndex(i).getClass().equals(Money.class)){
                    totalMoneyList.add((Money) entity.getItemUsingIndex(i));
                    entity.removeItem(entity.getItemUsingIndex(i));
                }
            }
        }
        for(int i = 0; i < totalMoneyList.size(); i++){
            totalMoney += totalMoneyList.get(i).getAmount();
        }
        temp = totalMoneyList.get(0).getName();
        if(totalMoney < item.getCost()){
            long temp3 = item.getCost() - totalMoney;
            System.out.println(this.getNames() + " не удалось купить " +
                    item.getName() +  " за " + totalMoney + " " + temp +
                    ". Не хватает: " + temp3 + " " + temp);
        }
        else{
            double temp3 = Math.random() * (people.size() - 1);
            int temp4 = (int) (Math.round(temp3));
            people.get(temp4).addItem(item);
            System.out.println(this.getNames() + " заплатили " + item.getCost() +
                    " " + temp + " и получили " + item.getName() + ". "
                    + item.getName() + " выдан: " + people.get(temp4).getName());
            temp2 = totalMoney - item.getCost();
            if(temp2 > 0 && temp2 % this.people.size() == 0) {
                temp2 = temp2 / this.people.size();
                for (Entity entity : this.people) {
                    entity.addItem(new Money(temp, temp2));
                }
            }
            else if(temp2 > 0 && temp2 % this.people.size() != 0){
                temp2 = (temp2 - 1) / this.people.size();
                for(int i = 1; i < this.people.size(); i++){
                    people.get(i).addItem(new Money(temp, temp2));
                }
                people.get(0).addItem(new Money(temp,temp2 + 1));
            }
        }
    }

    public void tryAccess(Room room){
        ArrayList<Key> keys = new ArrayList<>();
        Place entplace = null;
        boolean access = false;
        String temp0 = "";
        for(Entity entity : people) {
            entplace = entity.getLocation();
            for (int i = 0; i < entity.getItems().length; i++) {
                if (entity.getItemUsingIndex(i).getClass().equals(Key.class)) {
                    keys.add((Key) entity.getItemUsingIndex(i));
                    temp0 += entity.getName();
                }
            }
        }
        String temp = "";
        for(int i = 0; i < keys.size(); i++){
            if(keys.get(i).getId() == room.getId() && room.getRoomPlace() == entplace){
                access = true;
                temp += keys.get(i);
            }
        }
        if(access){
            System.out.println(temp0 + " использовал: " + temp
                    + ". " + this.getNames() + " очутились в "
                    + room.getName() + " " + room.getId());
            for(Entity entity : people) {
                entity.setLocation(room);
            }
        }
        else{
            System.out.println(this.getNames() + " не удалось попасть в "
                    + room.getName() + " " + room.getId() + ". Отсутствует: " +
                    Key.class.getName() + " " + room.getId());
            System.exit(0);
        }
    }

    public void open(IsOpenable canBeOpened){
        System.out.println(this.getNames() + " открыли " + canBeOpened.getName());
        canBeOpened.setOpen(true);
    }

    public void wantRest(){
        System.out.println(this.getNames() + " хотели отдохнуть");
    }

    public void see(IsSeeable canBeSeen){
        System.out.println(this.getNames() + " увидели " + canBeSeen.getName());
    }

    public void notice(IsNoticeable canBeNoticed){
        System.out.println(this.getNames() + " заметили " + canBeNoticed.getName());
    }

    public String getNames(){
        switch(people.size()){
            case 0: return "TheyIsEmpty";
            case 1: return people.get(0).getName();
            case 2: return people.get(0).getName() + " и " +
                    people.get(1).getName();
            default:
                String temp = "";
                for(int i = 0; i < people.size() - 1; i++){
                    temp += people.get(i).getName() + ", ";
                }
                temp = temp.substring(0, temp.length() - 2);
                temp += " и " + people.get(people.size() - 1).getName();
                return temp;
        }
    }

    @Override
    public String toString() {
        return "entities.They{" +
                "people=" + people +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        They they = (They) o;
        return Objects.equals(people, they.people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(people);
    }
}

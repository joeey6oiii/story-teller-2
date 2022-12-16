package entities;

import interfaces.*;
import items.*;
import places.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class They implements TryAble, FindAble, GoAble, OpenAble, ReadAble,
        PayToGetAble, SeeAble, NoticeAble, WantRestAble, ConsumeAble {
    private ArrayList<Entity> people = new ArrayList<>();

    public They(Entity ... people){
        Collections.addAll(this.people, people);
    }

    public void addPeople(Entity ... people){
        Collections.addAll(this.people, people);
    }

    public void setLocation(Place location){
        for(Entity entity : people){
            entity.setLocation(location);
        }
    }

    public ArrayList<Entity> getEntities(){
        return people;
    }

    public void find(IsFindable canBeFind){
        int keys = 0;
        if(canBeFind.getClass().equals(Room.class)){
            for(Entity entity : people){
                for(int i = 0; i < entity.getItems().size(); i++){
                    if(entity.getItemUsingIndex(i).getClass().equals(Key.class)) {
                        keys += 1;
                    }
                }
            }
            if(keys == 0){
                System.out.println(this.getNames() + " нашли случайный " + canBeFind.getName());
            }
            else{
                System.out.println(this.getNames() + " нашли " +
                        canBeFind.getName() + " " + ((Room) canBeFind).getId());
            }
        }
        else{
            System.out.println(this.getNames() + " нашли " + canBeFind.getName());
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
            for(int i = 0; i < entity.getItems().size(); i++){
                if(entity.getItemUsingIndex(i).getClass().equals(Money.class)){
                    totalMoneyList.add((Money) entity.getItemUsingIndex(i));
                    entity.removeItem(entity.getItemUsingIndex(i));
                }
            }
        }
        for (Money money : totalMoneyList) {
            totalMoney += money.getAmount();
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
            if(temp2 < people.size() && temp2 > 0){
                for(Entity entity : this.people){
                    if(temp2 != 0){
                        entity.addItem(new Money(temp, 1L));
                        temp2 -= 1;
                    }
                }
            }
            else{
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
    }

    public void tryAccess(Room room){
        ArrayList<Key> keys = new ArrayList<>();
        Place entityLocation = new DefaultLocation("Default Location");
        StringBuilder temp0 = new StringBuilder();
        boolean access = false;
        for(Entity entity : people) {
            entityLocation = entity.getLocation();
            for (int i = 0; i < entity.getItems().size(); i++) {
                if (entity.getItemUsingIndex(i).getClass().equals(Key.class)) {
                    keys.add((Key) entity.getItemUsingIndex(i));
                    temp0.append(entity.getName());
                }
            }
        }
        StringBuilder temp = new StringBuilder();
        for (Key key : keys) {
            if (key.getId() == room.getId() && room.getRoomPlace() == entityLocation) {
                access = true;
                temp.append(key);
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

    public void consume(IsConsumable... consumables){
        StringBuilder temp = new StringBuilder();
        for(IsConsumable food : consumables){
            temp.append(food.getName()).append(", ");
        }
        temp = new StringBuilder(temp.substring(0, temp.length() - 2));
        System.out.println(this.getNames() + " используют " + temp);
    }

    public String getNames(){
        switch(people.size()){
            case 0: return "TheyIsEmpty";
            case 1: return people.get(0).getName();
            case 2: return people.get(0).getName() + " и " +
                    people.get(1).getName();
            default:
                StringBuilder temp = new StringBuilder();
                for(int i = 0; i < people.size() - 1; i++){
                    temp.append(people.get(i).getName()).append(", ");
                }
                temp = new StringBuilder(temp.substring(0, temp.length() - 2));
                temp.append(" и ").append(people.get(people.size() - 1).getName());
                return temp.toString();
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
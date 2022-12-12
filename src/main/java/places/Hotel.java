package places;

import entities.*;
import enums.Status;
import interfaces.*;
import items.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Hotel extends Place implements Revisorable, FamousAble, TakeArriveAble {
    private Money money;
    private boolean lackOfInhabitants = true;
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<SignBoard> signBoard = new ArrayList<>();
    private ArrayList<Entity> tenants = new ArrayList<>();

    public Hotel() {
        super.setName("Безымянная гостиница");
    }

    public Hotel(String name) {
        super(name);
    }

    public Hotel(String name, Room... rooms) {
        super(name);
        this.rooms.addAll(Arrays.asList(rooms));
    }

    public Hotel(String name, Money money, Room... rooms) {
        super(name);
        this.money = money;
        this.rooms.addAll(Arrays.asList(rooms));
    }

    public String getCurrencyName() {
        return money.getName();
    }

    public void setCurrency(Money money) {
        this.money = money;
    }

    public Room getRoom(int id) {
        int index = 0;
        for (Room room : rooms) {
            if (room.getId() == id) {
                index = rooms.indexOf(room);
            }
        }
        return rooms.get(index);
    }

    public void setRooms(Room... rooms) {
        for (Room room : rooms) {
            this.rooms.add(room);
            room.setRoomPlace(this);
        }
    }

    public void addRooms(Room room) {
        this.rooms.add(room);
    }

    public void setTenants(Entity... entities) {
        tenants.addAll(Arrays.asList(entities));
    }

    public void addTenants(Entity... entities) {
        tenants.addAll(Arrays.asList(entities));
    }

    public void setSignBoard(SignBoard... signBoard) {
        this.signBoard.addAll(Arrays.asList(signBoard));
    }

    public SignBoard getSignBoard(int id) {
        int index = 0;
        for (SignBoard sign : signBoard) {
            if (sign.getId() == id) {
                index = signBoard.indexOf(sign);
            }
        }
        return signBoard.get(index);
    }

    public void takeArrive(Entity... entities) {
        String temp = "";
        if(entities.length == 1) {
            temp = entities[0].getName();
        }
        else if(entities.length == 2){
            temp = entities[0].getName() + " и " + entities[1].getName();
        }
        else{
            for(int i = 0; i < entities.length - 1; i++){
                temp += entities[i].getName() + ", ";
            }
            temp = temp.substring(0, temp.length() - 2);
            temp += " и " + entities[entities.length - 1].getName();
        }
        System.out.println(temp + " отправились ночевать в " + this.getName());
        for (Entity entity : entities) {
            entity.setLocation(this);
        }
    }

    public void famous(Status status) {
        System.out.println(this.getName() + " славилась " + status.getName());
    }

    public void lackOfInhabitants(Hotel hotel, Hotel... hotels) {
        int tempTrue = 0;
        int tempFalse = 0;
        for (Hotel h : hotels) {
            if (hotel.tenants.size() >= h.tenants.size()) {
                tempTrue += 1;
            } else {
                tempFalse += 1;
            }
        }
        if (tempTrue >= tempFalse) {
            System.out.println(this.getName() + " не испытывала " + Status.FLAW.getName() + " в жильцах");
            lackOfInhabitants = false;
        } else {
            System.out.println(this.getName() + " испытывала " + Status.FLAW.getName() + " в жильцах");
            lackOfInhabitants = true;
        }
    }

    public void getHotelRoomsInfo() {
        String temp = "";
        String temp2 = "";
        for (int i = 0; i < rooms.size(); i++) {
            temp += rooms.get(i).getRoomCost() + ", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        for (int j = 0; j < rooms.size(); j++) {
            temp2 += rooms.get(j).getName() + " " + rooms.get(j).getId() + ", ";
        }
        temp2 = temp2.substring(0, temp2.length() - 2);
        System.out.println("В " + this.getName() + " можно получить "
                + temp2 + " за " + temp + " " + getCurrencyName());
    }

    public void comparisonRoomCost(Hotel hotel, Hotel... hotels) {
        String tempString = "";
        String tempString2 = "";
        float temp1 = 0;
        float temp2 = 0;
        for (Hotel h : hotels) {
            tempString += h.getName() + ", ";
        }
        for(int g = 0; g < hotel.rooms.size(); g++) {
            tempString2 += rooms.get(g).getName() + " " + rooms.get(g).getId() + ", ";
        }
        tempString = tempString.substring(0, tempString.length() - 2);
        tempString2 = tempString2.substring(0, tempString2.length() - 2);
        for (int i = 0; i < hotel.rooms.size(); i++) {
            temp1 += (float) hotel.rooms.get(i).getRoomCost() / hotel.rooms.size();
        }
        for (Hotel h : hotels) {
            for (int j = 0; j < h.rooms.size(); j++) {
                temp2 += (float) h.rooms.get(j).getRoomCost() / h.rooms.size();
            }
        }
        temp2 = temp2 / hotels.length;
        if(temp2 > temp1){
            temp1 = temp2 / temp1;
            System.out.println(tempString2 + " в " + hotel.getName() + " в среднем в " + temp1 +
                    " раз дешевле, чем в " + tempString);
        }
        else if(temp1 > temp2){
            temp2 = temp1 / temp2;
            System.out.println(tempString2 + " в " + hotel.getName() + " в среднем в " + temp2 +
                    " раз дороже, чем в " + tempString);
        }
        else{
            System.out.println(tempString2 + " в " + hotel.getName()
                    + " в среднем стоят так же, как и в " + tempString);
        }
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "money=" + money +
                ", lackOfInhabitants=" + lackOfInhabitants +
                ", rooms=" + rooms +
                ", signBoard=" + signBoard +
                ", tenants=" + tenants +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hotel hotel = (Hotel) o;
        return lackOfInhabitants == hotel.lackOfInhabitants &&
                Objects.equals(money, hotel.money) && Objects.equals(rooms, hotel.rooms)
                && Objects.equals(signBoard, hotel.signBoard)
                && Objects.equals(tenants, hotel.tenants);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), money,
                lackOfInhabitants, rooms, signBoard, tenants);
    }
}
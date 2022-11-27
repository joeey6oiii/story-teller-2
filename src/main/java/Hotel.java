import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;

public class Hotel extends Place implements IHotelInfo, ICanBeFamous,
        ICanTakeArrive {
    private Room room;
    private Currency currency;
    private float RoomCost;
    private boolean lackOfInhabitants = true;
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<SignBoard> signBoard = new ArrayList<>();
    private ArrayList<Entity> tenants = new ArrayList<>();

    public Hotel(){
        super.setName("Безымянная гостиница");
    }

    public Hotel(String name){
        super(name);
    }

    public Hotel(String name, Room room){
        super(name);
        this.room = room;
    }

    public Hotel(String name, Room room, Currency currency){
        super(name);
        this.room = room;
        this.currency = currency;
    }

    public String getCurrencyName(){
        return currency.getName();
    }

    public Currency getCurrency(){
        return this.currency;
    }

    protected void setCurrency(Currency currency){
        this.currency = currency;
    }

    public String getRoomName(){
        return room.getName();
    }

    public float getRoomCost(){
        return RoomCost;
    }

    public void setRoomCost(float RoomCost){
        this.RoomCost = RoomCost;
    }

    public Room getRoom(){
        return this.room;
    }

    public void setRoom(Room room){
        this.room = room;
    }

    public void setRooms(Room ... rooms){
        if(this.rooms.size() == 0){
            this.rooms.add(room);
        }
        else {
            for (Room tempRoom : rooms) {
                this.rooms.add(tempRoom);
            }
        }
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public void setTenants(Entity ... entities){
        for(Entity entity : entities){
            tenants.add(entity);
        }
    }

    public void addTenants(Entity ... entities){
        for(Entity entity : entities){
            tenants.add(entity);
        }
    }

    public boolean getLackOfInhabitants(){
        return this.lackOfInhabitants;
    }

    public void setSignBoard(SignBoard ... signBoard){
        for(SignBoard sign : signBoard){
            this.signBoard.add(sign);
        }
    }

    public ArrayList<SignBoard> getSignBoardList(){
        return this.signBoard;
    }

    public SignBoard getSignBoard(int index){
        return this.signBoard.get(index);
    }

    public void takeArrive(Entity ... entities){
        System.out.println(Arrays.toString(entities) + " отправились ночевать в " + this.getName());
        for (Entity entity : entities){
            entity.setLocation(this);
        }
    }

    public void famous(Status status){
        System.out.println(this.getName() + " славилась " + status.getName());
    }

    public void lackOfInhabitants(Hotel hotel, Hotel ... hotels){
        int tempTrue = 0;
        int tempFalse = 0;
        for(Hotel h : hotels){
            if(hotel.tenants.size() >= h.tenants.size()){
                tempTrue += 1;
            }
            else{
                tempFalse += 1;
            }
        }
        if(tempTrue >= tempFalse){
            System.out.println(this.getName() + " не испытывала " + Status.FLAW.getName() + " в жильцах");
            lackOfInhabitants = false;
        }
        else{
            System.out.println(this.getName() + " испытывала " + Status.FLAW.getName() + " в жильцах");
            lackOfInhabitants = true;
        }
    }

    public void getHotelRoomInfo(TimeExpression time, Status status) {
        System.out.println("За " + this.getRoomCost() + " " +
                getCurrencyName() + " в " + this.getName() +
                " можно получить " + time.getName() + " " +
                status.getName() + " " + getRoomName());
    }

    public void comparisonRoomCost(Hotel hotel, Hotel ... hotels){
        String tempString = "";
        for(Hotel h : hotels){
            tempString += h.getName() + ", ";
        }
        tempString = tempString.substring(0, tempString.length() - 2);
        float temp = 0;
        for(Hotel h : hotels){
            temp += h.getRoomCost() / hotel.getRoomCost();
            }
        temp = temp / hotels.length;
        System.out.println(hotel.room.getName() + " в " + hotel.getName() + " в " + temp +
                " раз дешевле, чем в " + tempString);
        }
}

import java.util.Arrays;

public class Hotel extends Place implements IHotelInfo, ICanBeFamous, IAbleArrive{
    private Room room;
    private Currency currency;

    public Hotel(){
        super.setName("Любая другая гостиница");
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

    public String getCurrency(){
        return currency.getName();
    }

    protected void setCurrency(Currency currency){
        this.currency = currency;
    }

    public String getRoom(){
        return room.getName();
    }

    public void setRoom(Room room){
        this.room = room;
    }

    public void famous(Status status){
            System.out.println(this.getName() + " славилась " + status.getName());
    }

    public void arrive(Entity ... entities){
        System.out.println(Arrays.toString(entities) + " отправились ночевать в " + this.getName());
        for (Entity entity : entities){
            entity.setLocation(this);
        }
    }

    public void getHotelRoom(TimeExpression time, Status status) {
        System.out.println("За " + room.getRoomCost() + " " +
                getCurrency() + " в " + this.getName() +
                " можно получить " + time.getName() + " " +
                status.getName() + " " + getRoom());
    }

    public void comparisonRoomCost(Hotel hotel1, Hotel hotel2){
        if(hotel1.room.getRoomCost() == hotel2.room.getRoomCost()){
            System.out.println("стоимости " + hotel1.room.getName() + " в " + hotel1.getName() + " и "
                    + hotel2.room.getName() + " в " + hotel2.getName() + " не отличаются");
        }
        float cost_difference;
        if(hotel1.room.getRoomCost() > hotel2.room.getRoomCost()){
            cost_difference = hotel1.room.getRoomCost() / hotel2.room.getRoomCost();
            System.out.println(hotel1.room.getName() + " в " + hotel1.getName() + " в " + cost_difference +
                    " раза дороже, чем в " + hotel2.getName());
        }
        else{
            cost_difference = hotel2.room.getRoomCost() / hotel1.room.getRoomCost();
            System.out.println(hotel1.room.getName() + " в " + hotel1.getName() + " в " + cost_difference +
                    " раза дешевле, чем в " + hotel2.getName());
        }
    }
}

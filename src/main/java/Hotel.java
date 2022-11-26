public class Hotel extends Place implements ForHotel, IDoNotExperience, ICanBeFamous{
    private Room room;
    private Currency currency;
    private Tenants abtenants;
    private String notification;

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

    public String getAbstractTenants(){
        return abtenants.getName();
    }

    public void setAbstractTenants(Tenants tenants){
        this.abtenants = tenants;
    }

    public void famous(Status status){
            System.out.println(this.getName() + " славилась " + Status.whatStatus(status));
    }

    public void getHotelRoom(OverTime time, Status status) {
        System.out.println("За " + room.getRoomCost() + " " +
                getCurrency() + " в " + this.getName() +
                " можно получить " + OverTime.whatOverTime(time) + " " +
                Status.whatStatus(status) + " " + getRoom());
    }

    public void comparisonRoomCost(Hotel hotel1, Hotel hotel2){
        if(hotel1.room.getRoomCost() == hotel2.room.getRoomCost()){
            System.out.println("стоимости " + hotel1.room.getName() + " и "
                    + hotel2.room.getName() + " в " + hotel2.getName() + " не отличаются");
        }
        float cost_difference;
        if(hotel1.room.getRoomCost() > hotel2.room.getRoomCost()){
            cost_difference = hotel1.room.getRoomCost() / hotel2.room.getRoomCost();
            System.out.println(hotel1.room.getName() + " в " + cost_difference +
                    " раза дороже, чем в " + hotel2.getName());
        }
        else{
            cost_difference = hotel2.room.getRoomCost() / hotel1.room.getRoomCost();
            System.out.println(hotel1.room.getName() + " в " + cost_difference +
                    " раза дешевле, чем в " + hotel2.getName());
        }
    }

    public void noExperience(Status status){
            System.out.println(this.getName() + " не испытывала " +
                    Status.whatStatus(status) + " в " + getAbstractTenants());
    }
}

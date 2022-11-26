public class Room extends Place{
    private float RoomCost = 0;

    public Room(){
        super.setName("Безымянная комната");
    }

    public Room(String name){
        super(name);
    }

    public float getRoomCost(){
        return RoomCost;
    }

    public void setRoomCost(float RoomCost){
        this.RoomCost = RoomCost;
    }
}
import java.util.ArrayList;

public class Room extends Place implements RoomInfo {
    private long RoomCost = 0;
    private int id;
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
        System.out.println("В " + this.getName() + " были " + this.getItemsToString());
    }

    public void setItems(Item... items){
        for(Item item : items){
            this.items.add(item);
        }
    }

    public void addItems(Item... items){
        for(Item item : items){
            this.items.add(item);
        }
    }

    public String getItemsToString(){
        String temp = "";
        for(int i = 0; i < items.size() - 1; i++){
            temp += items.get(i).getName() + ", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        temp += " и " + items.get(items.size() - 1).getName();
        return temp;
    }
}
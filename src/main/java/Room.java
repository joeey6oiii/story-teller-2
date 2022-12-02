import java.util.ArrayList;

public class Room extends Place implements RoomInfo, CanReplaceItems {
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
        System.out.println("В " + this.getName() + " были " + this.getItemsNames());
    }

    public Place getRoomPlace() {
        return location;
    }

    public void setRoomPlace(Place location) {
        this.location = location;
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

    public void replaceItem(CanBeReplaced itemToReplace, CanBeReplaced itemForReplace) {
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
}
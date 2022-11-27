import java.util.ArrayList;

public class Room extends Place implements IRoomInfo{
    private ArrayList<Item> items = new ArrayList<>();

    public Room(){
        super.setName("Безымянная комната");
    }

    public Room(String name){
        super(name);
    }


    public void addItems(Item... items){
        for(Item item : items){
            this.items.add(item);
        }
    }

    public ArrayList<Item> getItemsList(){
        return items;
    }

    public void setItems(Item... items){
        for(Item item : items){
            this.items.add(item);
        }
    }

    public void getItems() {
        System.out.println("В " + this.getName() + " были " + this.toString());
    }

    @Override
    public String toString(){
        String temp = "";
        for(int i = 0; i < items.size() - 1; i++){
            temp += items.get(i).getName() + ", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        temp += " и " + items.get(items.size() - 1).getName();
        return temp;
    }
}
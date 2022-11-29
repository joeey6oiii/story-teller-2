import java.util.ArrayList;

public class They implements CanFind, CanRead, CanGo, CanPayToGet {
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

    public void findPlace(Place location){
        System.out.println(this.getNames() + " нашли " + location.getName());
    }

    public void findItem(Item item){
        System.out.println(this.getNames() + " нашли " + item.getName());
    }

    public void read(CanBeRead readable) {
        System.out.println(this.getNames() + " читали " +
                readable.getClass().getName() + ": " + readable.say());
    }

    public void go(Place location) {
        System.out.println(this.getNames() + " шли в " + location.getName());
        this.setLocation(location);
    }

    public void payToGet(Item item) {
        ArrayList<Money> totalMoneyList = new ArrayList<>();
        String temp;
        long totalMoney = 0;
        long temp2;
        for(Entity entity : people){
            for(int i = 0; i < entity.getItems().length; i++){
                if(entity.getItemUIN(i).getClass().equals(Money.class)){
                    totalMoneyList.add((Money) entity.getItemUIN(i));
                    entity.removeItem(entity.getItemUIN(i));
                }
            }
        }
        for(int i = 0; i < totalMoneyList.size(); i++){
            totalMoney += totalMoneyList.get(i).getAmount();
        }
        temp = totalMoneyList.get(0).getName();
        if(totalMoney >= item.getCost()){
            System.out.println(this.getNames() + " заплатили " + item.getCost() +
                    " " + temp + " и получили " + item.getName());
            double temp3 = Math.random() * (people.size() - 1);
            int temp4 = (int) Math.round(temp3);
            people.get(temp4).addItem(item);
        }
        temp2 = totalMoney - item.getCost();
        if(temp2 > 0 && temp2 % 2 == 0){
            temp2 = temp2 / this.people.size();
            for(Entity entity : this.people){
                entity.addItem(new Money(temp, temp2));
            }
        }
        else if(temp2 > 0 && temp2 % 2 != 0){
            temp2 = (temp2 - 1) / this.people.size();
            for(Entity entity : this.people){
                entity.addItem(new Money(temp, temp2));
            }
            double temp5 = Math.random() * (people.size() - 1);
            int temp6 = (int) Math.round(temp5);
            people.get(temp6).addItem(new Money(temp, 1));
        }
    }

    public Entity[] getEntities(){
        return people.toArray(new Entity[people.size()]);
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
        return "They{" +
                "people=" + people +
                '}';
    }
}

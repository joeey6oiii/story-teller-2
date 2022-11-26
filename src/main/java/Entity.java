//import java.util.ArrayList;

public abstract class Entity {
    private String name;
    private Place location;
//    private ArrayList<Status> statuses = new ArrayList<>();

    public Entity(){}

    public Entity(String name){
        this.name = name;
    }

    public Entity(String name, Place location){
        this.name = name;
        this.location = location;
    }

//    public Entity(String name, Status ... statuses){
//        this.name = name;
//        for(Status status : statuses){
//            this.statuses.add(status);
//        }
//    }

//    public Entity(String name, Place location, Status ... statuses){
//        this.name = name;
//        this.location = location;
//        for(Status status : statuses){
//            this.statuses.add(status);
//        }
//    }

    public String getName(){
        return name;
    }

    public Place getLocation(){
        return location;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLocation(Place location){
        this.location = location;
    }

//    public void addStatus(Status ... statuses){
//        for(Status status : statuses){
//            this.statuses.add(status);
//        }
//    }

    @Override
    public String toString(){
        return getClass().getName() + "[" + "name=" + this.name +
                ",location=" + this.location + "]";
    }
}

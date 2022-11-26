public abstract class Entity {
    private String name;
    private Place location;

    public Entity(){}

    public Entity(String name){
        this.name = name;
    }

    public Entity(String name, Place location){
        this.name = name;
        this.location = location;
    }

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


    @Override
    public String toString(){
        return getClass().getName() + "[" + "name=" + this.name +
                ",location=" + this.location + "]";
    }
}

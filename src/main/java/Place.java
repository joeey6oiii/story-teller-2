public abstract class Place {
    private String name;
    private Place location;

    public Place(){}

    public Place(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public Place getLocation(){
        return this.location;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return getClass().getName() + "[" + "name=" + this.name + "]";
    }
}

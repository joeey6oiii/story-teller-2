public class Hole extends Place  implements CanBeLeanedOutFrom{
    private Place location;

    public Hole(String name){
        super(name);
    }

    public Place getLocation() {
        return location;
    }

    public void setLocation(Place location) {
        this.location = location;
    }
}

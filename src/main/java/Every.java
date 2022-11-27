public class Every extends Entity implements ICanRead, ICanGo{
    private boolean allRead = false;

    public Every(String name) {
        super(name);
    }

    public void read(ICanBeRead readable) {
        if(readable.toString().equals("\"Самые дешевые номера на свете\"")){
            allRead = true;
        }
        if(allRead) {
            System.out.println(this.getName() + " читал " +
                    readable.getClass().getName() + ": " + readable.say());
        }
        else{
            System.out.println(this.getName() + " читал " +
                    readable.getClass().getName() + " невнимательно");
        }
    }

    public void go(Place location) {
        if(allRead) {
            System.out.println(this.getName() + " шел " +
                    Description.NO_BRAIN.getName() + " в " + location.getName());
            this.setLocation(location);
        }
        // Went into another location
        else{
            System.out.println(this.getName() + " шел в " + location.getName());
            this.setLocation(location);
        }
    }
}

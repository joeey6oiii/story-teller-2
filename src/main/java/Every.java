public class Every extends Entity implements CanRead, CanGo {
    private boolean allRead = false;

    public Every(String name) {
        super(name);
    }

    public void read(CanBeRead readable) {
        if(readable.toString().equals("\"Самые дешевые номера на свете\"")){
            allRead = true;
        }
        if(allRead) {
            System.out.println(this.getName() + " читал " +
                    readable.getClass().getName() + ": " + readable.say());
        }
        // Read another readable obj
        else{
            System.out.println(this.getName() + " читал " +
                    readable.getClass().getName() + ": " + readable.say());
        }
    }

    public void go(Place location) {
        if(allRead) {
            System.out.println(this.getName() + " шел " +
                    Description.NO_BRAIN.getName() + " в " + location.getName());
            this.setLocation(location);
            allRead = false;
        }
        // Went to another location
        else{
            System.out.println(this.getName() + " шел в " + location.getName());
            this.setLocation(location);
        }
    }
}

public class Key extends Item{
    private int id;

    public Key(int id, String name){
        super(name);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

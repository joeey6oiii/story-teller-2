public class Human extends Entity {

    public Human(){
        super.setName("Человек");
    }

    public Human(String name){
        super(name);
    }

    public Human(String name, Place location){
        super(name, location);
    }

}

public class Human extends Entity implements CanPut {

    public Human(){
        super.setName("Человек");
    }

    public Human(String name){
        super(name);
    }

    public Human(String name, Place location){
        super(name, location);
    }

    public void put(CanBePut canBePut, CanTakePut canTakePut) {
        System.out.println(this.getName() + " положил " + canBePut.getName()
                + " на: " + canTakePut.getName());
    }
}

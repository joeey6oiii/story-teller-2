public class Human extends Entity implements IAbleToRead, IAbleToGo{

    public Human(){
        super.setName("Человек");
    }

    public Human(String name){
        super(name);
    }

    public Human(String name, Place location){
        super(name, location);
    }

    public void read(Where where, Object what){
        System.out.println(this.toString() + " читал " +
                Where.getWhere(where) + " " + what);
    }

    public void go(Place location, ToDo toDo){
        System.out.println(this.toString() +
                " шел" + ToDo.whatToDo(toDo) + " в " + location.toString());
    }
}

package items;

import interfaces.*;

public class Meal extends Item implements IsConsumable, IsPraiseable, IsSeemable {
    public Meal(){
        super("Еда");
    }

    public Meal(String name){
        super(name);
    }

    public Meal(String name, long cost){
        super(name, cost);
    }
}

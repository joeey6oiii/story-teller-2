package entities;

import interfaces.*;
import items.*;
import places.*;

public class Human extends Entity implements PutAble{

    public Human(){
        super.setName("Человек");
    }

    public Human(String name){
        super(name);
    }

    public Human(String name, Place location){
        super(name, location);
    }

    public void put(IsPutable canBePut, TakePutAble canTakePut) {
        System.out.println(this.getName() + " положил " + canBePut.getName()
                + " на " + canTakePut.getName());
        canTakePut.addItems((Item) canBePut);
        this.removeItem((Item) canBePut);
    }
}

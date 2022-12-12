package entities;

import enums.*;
import interfaces.*;
import items.*;
import places.*;

public class Human extends Entity implements PutAble, PraiseAble,
        SeemAble{

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

    public void praise(IsPraiseable ... isPraiseables){
        StringBuilder temp = new StringBuilder();
        for(IsPraiseable praiseable : isPraiseables){
            temp.append(praiseable.getName()).append(", ");
        }
        temp = new StringBuilder(temp.substring(0, temp.length() - 2));
        System.out.println(this.getName() + " хвалит " + temp);
    }

    public void seem(Status status, IsSeemable ... isSeemables){
        StringBuilder temp = new StringBuilder();
        for(IsSeemable seemable : isSeemables){
            temp.append(seemable.getName()).append(", ");
        }
        temp = new StringBuilder(temp.substring(0, temp.length() - 2));
        System.out.println(this.getName() + " кажется: " + temp + " " + status.getName());
    }
}
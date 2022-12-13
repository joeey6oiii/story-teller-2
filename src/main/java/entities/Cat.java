package entities;

import interfaces.*;

public class Cat extends Animal implements ConsumeAble {
    public Cat(String name) {
        super(name);
    }

    public void consume(IsConsumable... consumables) {
        StringBuilder sb = new StringBuilder();
        for(IsConsumable consumable : consumables){
            sb.append(consumable.getName()).append(", ");
        }
        if(sb.length() > 0){
            sb = new StringBuilder(sb.substring(0, sb.length() - 2));
            System.out.println(getName() + " использовал " + sb);
        }
        else{
            System.out.println(getName() + " ничего не использовал");
        }
    }
}

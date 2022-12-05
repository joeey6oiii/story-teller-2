package items;

import interfaces.CanBeReplaced;

public class ElectricSwitch extends Item implements CanBeReplaced {
    public ElectricSwitch(String name){
        super(name);
    }
}

package items;

import interfaces.IsReplaceable;

public class ElectricSwitch extends Item implements IsReplaceable {
    public ElectricSwitch(String name){
        super(name);
    }
}

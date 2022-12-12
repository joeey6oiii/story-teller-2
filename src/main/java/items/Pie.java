package items;

import interfaces.*;

public class Pie extends Item implements IsEatable, IsPraiseable {
    public Pie(String name){
        super(name);
    }
}

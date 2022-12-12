package items;

import interfaces.*;

public class Soup extends Item implements IsEatable, IsPraiseable {
    public Soup(String name){
        super(name);
    }
}

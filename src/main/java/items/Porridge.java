package items;

import interfaces.*;

public class Porridge extends Item implements IsEatable, IsPraiseable {
    public Porridge(String name){
        super(name);
    }
}

package entities;

import places.Place;

public class Neznayka extends Human {
    public Neznayka(String name){
        super(name);
    }

    public Neznayka(String name, Place location){
        super(name, location);
    }
}

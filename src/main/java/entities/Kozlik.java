package entities;

import places.Place;

public class Kozlik extends Human {
    public Kozlik(String name){
        super(name);
    }

    public Kozlik(String name, Place location){
        super(name, location);
    }
}

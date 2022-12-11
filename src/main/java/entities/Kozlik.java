package entities;

import places.*;

public class Kozlik extends Human {
    public Kozlik(String name){
        super(name);
    }

    public Kozlik(String name, Place location){
        super(name, location);
    }
}

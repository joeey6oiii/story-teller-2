package items;

import enums.*;
import interfaces.*;

public class Bell extends Item implements RingAble {
    public Bell(String name) {
        super(name);
    }

    public void ring(TimeExpression time) {
        System.out.println(time.getName() + " зазвенел " + this.getName());
    }
}

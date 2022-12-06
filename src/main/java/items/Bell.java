package items;

import enums.TimeExpression;
import interfaces.RingAble;

public class Bell extends Item implements RingAble {
    public Bell(String name) {
        super(name);
    }

    public void ring(TimeExpression time) {
        System.out.println(time.getName() + " зазвенел " + this.getName());
    }
}

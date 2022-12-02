public class Bell extends Item implements CanRing {
    public Bell(String name) {
        super(name);
    }

    public void ring(TimeExpression time) {
        System.out.println(time.getName() + " зазвенел " + this.getName());
    }
}

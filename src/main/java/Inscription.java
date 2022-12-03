public class Inscription implements CanBeRead, BlinkAble {
    private String scription;

    public Inscription(String scription) {
        this.scription = scription;
    }

    public String getName() {
        return scription;
    }

    public void setScription(String scription) {
        this.scription = scription;
    }

    public String say() {
        return getName();
    }

    public void blink(Colors color) {
        System.out.println("Замигала" + " " + color.getName() + " надпись: " + this.getName());
    }
}

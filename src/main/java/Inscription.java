public class Inscription implements CanBeRead {
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
}

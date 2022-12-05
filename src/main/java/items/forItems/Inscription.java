package items.forItems;

import enums.Colors;
import interfaces.BlinkAble;
import interfaces.CanBeRead;

import java.util.Objects;

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
        System.out.println("Замигала " + color.getName() + " надпись: " + this.getName());
    }

    @Override
    public String toString() {
        return "Inscription{" +
                "scription='" + scription + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inscription that = (Inscription) o;
        return Objects.equals(scription, that.scription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scription);
    }
}

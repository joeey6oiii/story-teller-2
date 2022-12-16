package items;

import interfaces.*;

import java.util.Objects;

public class Chair extends Item implements IsSitable {
    private boolean busy;

    public Chair(String name) {
        super(name);
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    @Override
    public String toString() {
        return "Chair{" +
                "busy=" + busy +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Chair chair = (Chair) o;
        return busy == chair.busy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), busy);
    }
}

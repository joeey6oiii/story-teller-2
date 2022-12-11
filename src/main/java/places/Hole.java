package places;

import interfaces.*;

import java.util.Objects;

public class Hole extends Place implements IsLeanable {
    private Place location;

    public Hole(String name){
        super(name);
    }

    public Place getLocation() {
        return location;
    }

    public void setLocation(Place location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Hole{" +
                "location=" + location +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hole hole = (Hole) o;
        return Objects.equals(location, hole.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), location);
    }
}

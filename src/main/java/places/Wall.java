package places;

import java.util.Objects;

public class Wall extends Place {
    private Hole hole;

    public Wall(String name){
        super(name);
    }

    public Wall(String name, Hole hole) {
        super(name);
        hole.setLocation(this);
    }

    public Hole getHole(){
        return hole;
    }

    public void setHole(Hole hole){
        this.hole = hole;
        hole.setLocation(this);
    }

    @Override
    public String toString() {
        return "Wall{" +
                "hole=" + hole +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Wall wall = (Wall) o;
        return Objects.equals(hole, wall.hole);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hole);
    }
}

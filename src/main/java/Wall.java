public class Wall extends Place{
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
}

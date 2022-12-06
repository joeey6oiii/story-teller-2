package places;

import interfaces.IsFindable;

import java.util.Objects;

public abstract class Place implements IsFindable {
    private String name;

    public Place(){}

    public Place(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return getClass().getName() + "[" + "name=" + this.name + "]";
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj) return true;

        if (obj == null || obj.getClass() != this.getClass()) return false;

        Place other = (Place) obj;

        return Objects.equals(name, other.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
}

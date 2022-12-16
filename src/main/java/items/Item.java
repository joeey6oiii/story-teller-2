package items;

import interfaces.*;

import java.util.Objects;

public abstract class Item implements IsFindable, IsPutable {
    private String name;
    private long cost;

    {
        name = "Предмет";
    }

    public Item(){}

    public Item(String name) {
        this.name = name;
    }

    public Item(String name, long cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "items.Item{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return cost == item.cost && Objects.equals(name, item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cost);
    }
}

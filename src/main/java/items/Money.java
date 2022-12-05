package items;

import java.util.Objects;

public class Money extends Item {
    private String name;
    private long amount;

    public Money(){
        this.name = "Некоторая валюта";
    }

    public Money(String name){
        this.name = name;
    }

    public Money(String name, long amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName(){
        return name;
    }

    public long getAmount(){
        return amount;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "items.Money{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Money money = (Money) o;
        return amount == money.amount && Objects.equals(name, money.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, amount);
    }
}

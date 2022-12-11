package items;

import interfaces.*;
import items.forItems.*;

import java.util.ArrayList;
import java.util.Objects;

public class Uvula extends Item implements IsReadable, LeanOutAble, IsNoticeable {
    private ArrayList<Inscription> scription = new ArrayList<>();

    public Uvula(String name, Inscription... inscription) {
        super(name);
        for(Inscription annotation : inscription){
            this.scription.add(annotation);
        }
    }

    public void setInscription(Inscription... inscription) {
        for(Inscription annotation : inscription){
            this.scription.add(annotation);
        }
    }

    public Inscription getInscription(int index){
        return scription.get(index);
    }

    public String say(){
        return this.getScriptions();
    }

    public void leanOut(IsLeanable location) {
        System.out.println("Из " + location.getName() +
                " в " + location.getLocation().getName() +
                " высунулся " + this.getName());
    }

    public String getScriptions() {
        String temp = "";
        for(Inscription annotation : scription){
            temp += annotation.getName() + ", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        return temp;
    }

    @Override
    public String toString() {
        return "Uvula{" +
                "scription=" + scription +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Uvula uvula = (Uvula) o;
        return Objects.equals(scription, uvula.scription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), scription);
    }
}

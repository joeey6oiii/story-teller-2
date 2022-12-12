package items;

import interfaces.*;
import items.forItems.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class SignBoard extends Item implements IsReadable {
    private final int id;
    private ArrayList<Inscription> scription = new ArrayList<>();

    public SignBoard(String name, int id, Inscription... inscription) {
        super(name);
        this.id = id;
        this.scription.addAll(Arrays.asList(inscription));
    }

    public void setInscription(Inscription... inscription) {
        Collections.addAll(this.scription, inscription);
    }

    public int getId() {
        return id;
    }

    public String say(){
        return this.getScriptions();
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
        return "items.SignBoard{" +
                "id=" + id +
                ", scription=" + scription +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SignBoard signBoard = (SignBoard) o;
        return id == signBoard.id && Objects.equals(scription, signBoard.scription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, scription);
    }
}
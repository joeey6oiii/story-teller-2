import java.util.ArrayList;

public class SignBoard implements CanBeRead {
    private ArrayList<Inscription> scription = new ArrayList<>();

    public SignBoard(Inscription ... inscription) {
        for(Inscription annotation : inscription){
            this.scription.add(annotation);
        }
    }

    public void setInscription(Inscription ... inscription) {
        for(Inscription annotation : inscription){
            this.scription.add(annotation);
        }
    }

    public Inscription getScription(int index){
        return scription.get(index);
    }

    public String say(){
        return this.toString();
    }

    @Override
    public String toString() {
        String temp = "";
        for(Inscription annotation : scription){
            temp += annotation.getName() + ", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        return temp;
    }
}
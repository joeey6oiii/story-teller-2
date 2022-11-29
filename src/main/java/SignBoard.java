import java.util.ArrayList;

public class SignBoard implements CanBeRead {
    private int id;
    private ArrayList<Inscription> scription = new ArrayList<>();

    public SignBoard(int id, Inscription ... inscription) {
        this.id = id;
        for(Inscription annotation : inscription){
            this.scription.add(annotation);
        }
    }

    public void setInscription(Inscription ... inscription) {
        for(Inscription annotation : inscription){
            this.scription.add(annotation);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String say(){
        return this.getToString();
    }

    public String getToString() {
        String temp = "";
        for(Inscription annotation : scription){
            temp += annotation.getName() + ", ";
        }
        temp = temp.substring(0, temp.length() - 2);
        return temp;
    }
}
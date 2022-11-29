import java.util.ArrayList;

public class SignBoard extends Item implements CanBeRead {
    private ArrayList<Inscription> scription = new ArrayList<>();

    public SignBoard(String name, int id, Inscription ... inscription) {
        super(name, id);
        for(Inscription annotation : inscription){
            this.scription.add(annotation);
        }
    }

    public void setInscription(Inscription ... inscription) {
        for(Inscription annotation : inscription){
            this.scription.add(annotation);
        }
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
}
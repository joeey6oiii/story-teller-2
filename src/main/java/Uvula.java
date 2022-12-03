import java.util.ArrayList;

public class Uvula extends Item implements CanBeRead,
        LeanOutAble, CanBeNoticed{
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

    public void leanOut(CanBeLeanedOutFrom location) {
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
}

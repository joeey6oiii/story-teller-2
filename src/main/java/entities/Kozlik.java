package entities;

import interfaces.*;
import places.*;

import java.util.Arrays;

public class Kozlik extends Human implements Similarable {
    public Kozlik(String name){
        super(name);
    }

    public Kozlik(String name, Place location){
        super(name, location);
    }

    public void similar(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        if(object instanceof Entity) {
            if (this.getName().equals(((Entity) object).getName())) {
                stringBuilder.append(((Entity) object).getName()).append(", ");
            }
            else if(this.getLocation().equals(((Entity) object).getLocation())){
                stringBuilder.append(((Entity) object).getLocation().getName()).append(", ");
            }
            else if(Arrays.equals(this.getItems(), ((Entity) object).getItems())){
                stringBuilder.append(Arrays.toString(((Entity) object).getItems())).append(", ");
            }
            else if(Arrays.equals(this.getStatuses(), ((Entity) object).getStatuses())){
                stringBuilder.append(Arrays.toString(((Entity) object).getStatuses())).append(", ");
            }
            if(stringBuilder.length() > 0){
                stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - 2));
                System.out.println(this.getName() +  " похож на " +
                        ((Entity) object).getName() + " по следующим параметрам: " + stringBuilder);
            }
            else {
                System.out.println(this.getName() + " не похож на " + ((Entity) object).getName());
            }
        }
        else{
            System.out.println("IncomparableTypesException: " + this.getName() + " и " + object + " несравнимы");
        }
    }
}

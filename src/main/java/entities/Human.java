package entities;

import enums.*;
import exceptions.unchecked.IncorrectObject;
import interfaces.*;
import items.*;
import places.*;

import java.util.Arrays;

public class Human extends Entity implements PutAble, PraiseAble, SeemAble,
        SmackAble, SquintAble, QuackAble, SitAble, UnSitAble, Similarable{
    private final Lips lips = new Lips("Губы");

    public Human(){
        super.setName("Человек");
    }

    public Human(String name){
        super(name);
    }

    public Human(String name, Place location){
        super(name, location);
    }

    public Lips getLips() {
        return lips;
    }

    public void put(IsPutable canBePut, TakePutAble canTakePut) {
        System.out.println(this.getName() + " положил " + canBePut.getName()
                + " на " + canTakePut.getName());
        canTakePut.addItems((Item) canBePut);
        this.removeItem((Item) canBePut);
    }

    public void sit(IsSitable isSitable){
        if(!isSitable.isBusy()){
            System.out.println(this.getName() + " сел на " + isSitable.getName() + " в " + this.getLocation().getName());
            isSitable.setBusy(true);
        }
        else{
            System.out.println(this.getName() + " не смог сесть на " + isSitable.getName() + ", так как он занят");
        }
    }

    public void unSit(IsSitable isSitable){
        if(isSitable.isBusy()){
            System.out.println(this.getName() + " покинул " + isSitable.getName());
            isSitable.setBusy(false);
        }
        else{
            System.out.println(this.getName() + " не находится на " + isSitable.getName());
        }
    }

    public void praise(IsPraiseable ... isPraiseables){
        StringBuilder temp = new StringBuilder();
        for(IsPraiseable praiseable : isPraiseables){
            temp.append(praiseable.getName()).append(", ");
        }
        temp = new StringBuilder(temp.substring(0, temp.length() - 2));
        System.out.println(this.getName() + " хвалит " + temp);
    }

    public void seem(Status status, IsSeemable ... isSeemables){
        StringBuilder temp = new StringBuilder();
        for(IsSeemable seemable : isSeemables){
            temp.append(seemable.getName()).append(", ");
        }
        temp = new StringBuilder(temp.substring(0, temp.length() - 2));
        System.out.println(this.getName() + " кажется " + status.getName() + ": " + temp);
    }

    public void quack(){
        System.out.println(this.getName() + " крякает");
    }

    public void squint(){
        System.out.println(this.getName() + " жмурится");
    }

    public void smack(IsSmackable isSmackable){
        System.out.println(this.getName() + " чмокает " + isSmackable.getName());
    }

    public void similar(Object object) {
        StringBuilder stringBuilder = new StringBuilder();
        if(!(object instanceof Entity)) {
            throw new IncorrectObject("Невозможно сравнить объекты разных типов: "
                    + this.getClass().getName() + " и " + object.getClass().getName());
        }
        else {
            if (this.getName().equals(((Entity) object).getName())) {
                stringBuilder.append(((Entity) object).getName()).append(", ");
            }
            if(this.getLocation().equals(((Entity) object).getLocation())){
                stringBuilder.append(((Entity) object).getLocation().getName()).append(", ");
            }
            if(Arrays.equals(this.getItems(), ((Entity) object).getItems())){
                stringBuilder.append(Arrays.toString(((Entity) object).getItems())).append(", ");
            }
            if(Arrays.equals(this.getStatuses(), ((Entity) object).getStatuses())){
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
    }

    private class Lips implements IsSmackable{
        private String name;

        public Lips(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
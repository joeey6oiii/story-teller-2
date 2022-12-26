package interfaces;

import exceptions.unchecked.IncorrectObjectException;

import java.lang.reflect.Field;

public interface Similarable {
    default void similar(Object object) throws IncorrectObjectException {
        Class<?> temp = this.getClass();
        Class<?> temp12 =this.getClass();
        Class<?> temp2 = object.getClass();
        Class<?> temp22 = object.getClass();
        while(!temp.equals(Object.class)){
            temp = temp.getSuperclass();
            if(!temp.equals(Object.class)){
                temp12 = temp;
            }
        }
        while(!temp2.equals(Object.class)){
            temp2 = temp2.getSuperclass();
            if(!temp2.equals(Object.class)){
                temp22 = temp2;
            }
        }
        if(!temp12.equals(temp22)){
            throw new IncorrectObjectException("Невозможно сравнить объекты разных типов: "
                    + temp12.getSimpleName() + " и " + temp22.getSimpleName());
        }
        Field[] fields = temp12.getDeclaredFields();
        Field[] fields2 = temp22.getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
        }
        for(Field field : fields2){
            field.setAccessible(true);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : fields){
            for(Field field1 : fields2){
                try {
                    if(field.get(this).equals(field1.get(object))){
                        stringBuilder.append(field.get(this)).append(", ");
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        if(stringBuilder.length() > 0){
            stringBuilder = new StringBuilder(stringBuilder.substring(0, stringBuilder.length() - 2));
            System.out.println(this.getClass().getSimpleName() + " похож на " +
                    object.getClass().getSimpleName() + " по следующим параметрам: " + stringBuilder);
        }
    }
}
public class Money extends Item{
    private String name;
    private int amount;

    public Money(){
        this.name = "Некоторая валюта";
    }

    public Money(String name){
        this.name = name;
    }

    public Money(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName(){
        return name;
    }

    public int getAmount(){
        return amount;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}

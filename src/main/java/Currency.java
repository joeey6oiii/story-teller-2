public class Currency {
    private String name;

    public Currency(){
        this.name = "Некоторая валюта";
    }

    public Currency(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    protected void setName(String name){
        this.name = name;
    }
}

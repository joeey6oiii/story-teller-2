package enums;

public enum TimeExpression {
    RIGHT_NOW("В это время"),
    THEN("Тогда"),
    RECENTLY("Недавно"),
    YESTERDAY("Вчера"),
    TODAY("Сегодня"),
    TOMORROW("Завтра");

    private final String time;

    TimeExpression(String time){
        this.time = time;
    }

    public String getName(){
        return time;
    }
}

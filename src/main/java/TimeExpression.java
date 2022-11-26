public enum TimeExpression {
    OVERNIGHT("на ночь"),
    FOR_EVENING("на вечер"),
    IN_THE_MORNING("на утро"),
    NOT_FOR_LONG("недолго"),
    RIGHT_NOW("в это время"),
    FOR_THE_DAY("на день");

    private final String time;

    TimeExpression(String time){
        this.time = time;
    }

    public String getName(){
        return time;
    }
}

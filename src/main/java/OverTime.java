public enum OverTime {
    OVERNIGHT,
    FOR_EVENING,
    IN_THE_MORNING,
    FOR_THE_DAY;

    public static String whatOverTime(OverTime OverTime){
        return switch (OverTime){
            case OVERNIGHT -> "на ночь";
            case FOR_EVENING -> "на вечер";
            case IN_THE_MORNING -> "на утро";
            case FOR_THE_DAY -> "на день";
        };
    }
}

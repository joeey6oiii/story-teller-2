public enum ToDo {
    SPEND_NIGHT,
    NOTHING,
    NO_THINK;

    public static String whatToDo(ToDo toDo){
        return switch (toDo){
            case SPEND_NIGHT -> " ночевать";
            case NOTHING -> "";
            case NO_THINK -> " не раздумывая";
        };
    }
}

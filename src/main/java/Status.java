public enum Status {
    CHEAPNESS,
    CHEAPER,
    FLAW,
    CONVENIENT;

    public static String whatStatus(Status status){
        return switch(status){
            case CHEAPNESS -> "дешевизна";
            case CHEAPER -> "дешевле";
            case FLAW -> "недостаток";
            case CONVENIENT -> "удобный";
        };
    }
}

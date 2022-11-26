public enum Where {
    SIGN,
    WALL,
    NOWHERE;

    public static String getWhere(Where where){
        return switch (where){
            case SIGN -> "на вывеске";
            case WALL -> "на стене";
            case NOWHERE -> "";
        };
    }
}

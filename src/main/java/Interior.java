public enum Interior {
    TABLE,
    CHAIR,
    CABINET,
    WATER_DISPENSER,
    TV;

    public static String whatInterior(Interior interior){
        return switch (interior){
            case TABLE -> "стол";
            case CHAIR -> "стул";
            case CABINET -> "шкаф";
            case WATER_DISPENSER -> "рукомойник";
            case TV -> "телевизор";
        };
    }
}

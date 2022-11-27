public enum Description {
    NO_BRAIN("не раздумывая"),
    NO_DESCRIPTION("");



    private final String description;
    Description(String description) {
        this.description = description;
    }

    public String getName() {
        return this.description;
    }
}

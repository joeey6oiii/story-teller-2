public enum Time {
    NIGHT("Ночь"),
    DAY("День"),
    MORNING("Утро");

    private final String timeExp;

    Time(String timeExp) {
        this.timeExp = timeExp;
    }

    public String getName(){
        return this.timeExp;
    }

}

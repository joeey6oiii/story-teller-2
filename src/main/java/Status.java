public enum Status {
    CHEAPNESS("дешевизна"),
    FLAW("недостаток"),
    CONVENIENT("удобный");

    private final String status;
    Status(String status) {
        this.status = status;
    }

    public String getName() {
        return this.status;
    }
}

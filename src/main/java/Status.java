public enum Status {
    CHEAPNESS("дешевизна"),
    FLAW("недостаток"),
    SMALL("маленькая"),
    CLEAR("чистенькая"),
    CONVENIENT("удобный"),
    NO_STATUS("");

    private final String status;
    Status(String status) {
        this.status = status;
    }

    public String getName() {
        return this.status;
    }
}

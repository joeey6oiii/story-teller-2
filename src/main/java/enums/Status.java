package enums;

public enum Status {
    CHEAPNESS("дешевизна"),
    FLAW("недостаток"),
    NO_STATUS("");

    private final String status;
    Status(String status) {
        this.status = status;
    }

    public String getName() {
        return this.status;
    }
}

package enums;

public enum Status {
    CHEAPNESS("дешевизна"),
    FLAW("недостаток"),
    SPECIAL_TASTY("Особенно вкусный");

    private final String status;
    Status(String status) {
        this.status = status;
    }

    public String getName() {
        return this.status;
    }
}

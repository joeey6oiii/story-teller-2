package enums;

public enum Status {
    CHEAPNESS("дешевизна"),
    FLAW("недостаток"),
    COLD("холодный"),
    HUNGRY("голодный"),
    SPECIAL_TASTY("Особенно вкусный");

    private final String status;
    Status(String status) {
        this.status = status;
    }

    public String getName() {
        return this.status;
    }
}

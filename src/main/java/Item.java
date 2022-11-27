public abstract class Item {
    private String name;

    public Item(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return this.getClass().getName() + "["
                + "name=" + name + "]";
    }
}

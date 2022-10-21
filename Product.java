public class Product {
    private String name;
    private String type;

    public Product(String proname, String protype) {
        this.name = proname;
        this.type = protype;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void accept(ReminderVisitor remVis) {
    }
}

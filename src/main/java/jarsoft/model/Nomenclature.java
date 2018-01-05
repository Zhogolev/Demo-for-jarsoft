package jarsoft.model;

public class Nomenclature {
    private int id;
    private String name;
    private Float price;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    public Nomenclature(int id, String name, Float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

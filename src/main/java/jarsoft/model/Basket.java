package jarsoft.model;

public class Basket {

    private float price;
    private String name;
    private int quantity;
    private int nomenclatureId;
    private String session;

    public Basket(float price, String name, int quantity, int nomenclatureId, String session) {
        this.price = price;
        this.name = name;
        this.quantity = quantity;
        this.nomenclatureId = nomenclatureId;
        this.session = session;
    }

    public int getNomenclatureId() {
        return nomenclatureId;
    }

    public String getSession() {
        return session;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setNomenclatureId(int nomenclatureId) {
        this.nomenclatureId = nomenclatureId;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

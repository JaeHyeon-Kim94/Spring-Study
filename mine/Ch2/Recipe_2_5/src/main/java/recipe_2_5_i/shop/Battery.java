package recipe_2_5_i.shop;

public class Battery extends Product {
    private Boolean rechargeable;

    public Battery() { super();
    }

    public Battery(String name, double price) {
        super(name, price);
    }

    public Boolean getRechargeable() {
        return rechargeable;
    }

    public void setRechargeable(Boolean rechargeable) {
        this.rechargeable = rechargeable;
    }
}

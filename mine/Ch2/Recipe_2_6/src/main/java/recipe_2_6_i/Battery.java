package recipe_2_6_i;

public class Battery extends Product {

    private boolean rechargeable;

    public Battery() {
        super();
    }

    public Battery(String name, double price, String discount) {
        super(name, price, discount);
    }

    public boolean getRechargeable() {
        return rechargeable;
    }

    // Getters and Setters
    public void setRechargeable(boolean rechargeable) {
        this.rechargeable = rechargeable;
    }
}

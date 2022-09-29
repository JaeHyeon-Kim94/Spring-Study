package recipe_2_6_i;

import java.text.DecimalFormat;

public abstract class Product {

    private String name;
    private double price;
    private String discount;

    public Product() {
    }

    public Product(String name, double price, String discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    // Getters and Setters
    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String toString() {
        //DecimalFormat df = new DecimalFormat("#%");
        //return name + " " + price + " (" + df.format(discount) + " discount!)";
        return name + " " + price + " (" + discount + " discount!)";
    }
}

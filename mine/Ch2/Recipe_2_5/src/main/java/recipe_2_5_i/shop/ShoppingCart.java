package recipe_2_5_i.shop;

import java.util.List;

public interface ShoppingCart {
    public void addItem(Product item);
    public List<Product> getItems();
}

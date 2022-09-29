package recipe_2_5_i.shop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class ShoppingCartPrototype implements ShoppingCart {
    private List<Product> items = new ArrayList<>();

    public void addItem(Product item) { items.add(item); }

    public List<Product> getItems() {
        return items;
    }
}

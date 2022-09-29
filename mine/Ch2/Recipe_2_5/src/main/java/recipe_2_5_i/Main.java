package recipe_2_5_i;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import recipe_2_5_i.config.ShopConfig;
import recipe_2_5_i.shop.Product;
import recipe_2_5_i.shop.ShoppingCart;
import recipe_2_5_i.shop.ShoppingCartPrototype;
import recipe_2_5_i.shop.ShoppingCartSingleton;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context
                = new AnnotationConfigApplicationContext(ShopConfig.class);




        Product aaa = context.getBean("aaa", Product.class);
        Product cdrw = context.getBean("cdrw", Product.class);
        Product dvdrw = context.getBean("dvdrw", Product.class);

        ShoppingCart singleton = context.getBean(ShoppingCartSingleton.class);
        singleton.addItem(aaa);
        singleton.addItem(cdrw);
        System.out.println("singleton cart contains : " + singleton.getItems());

        ShoppingCart singleton2 = context.getBean(ShoppingCartSingleton.class);
        System.out.println("singleton2 cart contains : " + singleton2.getItems());

        System.out.println("=======================================================");
        ShoppingCart prototype = context.getBean(ShoppingCartPrototype.class);
        prototype.addItem(aaa);
        prototype.addItem(cdrw);
        System.out.println("prototype cart contains : " + prototype.getItems());

        ShoppingCart prototype2 = context.getBean(ShoppingCartPrototype.class);
        System.out.println("prototype2 cart contains : " + prototype2.getItems());
    }


}

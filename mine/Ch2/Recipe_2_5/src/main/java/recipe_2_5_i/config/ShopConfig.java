package recipe_2_5_i.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import recipe_2_5_i.Main;
import recipe_2_5_i.shop.Battery;
import recipe_2_5_i.shop.Disc;
import recipe_2_5_i.shop.Product;

@Configuration
@ComponentScan(basePackageClasses = Main.class)
public class ShopConfig {
    @Bean
    public Product aaa(){
        Battery p1 = new Battery();
        p1.setName("AAA");
        p1.setPrice(2.5);
        p1.setRechargeable(false);
        return p1;
    }

    @Bean
    public Product cdrw(){
        Disc p2 = new Disc("CD-RW", 1.5);
        p2.setCapacity(700);
        return p2;
    }

    @Bean
    public Product dvdrw() {
        Disc p2 = new Disc("DVD-RW", 3.0);
        p2.setCapacity(700);
        return p2;
    }
}

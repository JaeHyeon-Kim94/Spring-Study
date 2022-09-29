package recipe_2_6_i.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import recipe_2_6_i.Battery;
import recipe_2_6_i.Disc;
import recipe_2_6_i.Main;
import recipe_2_6_i.Product;

@Configuration
@ComponentScan(basePackageClasses = Main.class)
/*
    properties 파일의 키-값형태 내용을 @PropertySource을 통해
    java config 클래스에 선언된 빈으로 변환함.
    스프링은 접두어가 classpath: 인 클래스패스에서 properties 파일을 찾음.
    단, @PropertySource를 통해 프로퍼티 파일을 로드하려면
    config 클래스에 PropertySourcesPlaceholderConfigurer 클래스를 빈으로 선언해야 한다.

*/
@PropertySource("classpath:discounts.properties")
public class ShopConfig {

    //"${key:defualt_value}" 즉 매치되는 key가 있으면 그 값을, 아니면 0을 할당한다.
    @Value("${specialcustomer.discount:0}")
    private String specialCustomerDiscountField;

    @Value("${summer.discount:0}")
    private String specialSummerDiscountField;

    @Value("${endofyear.discount:0}")
    private String specialEndofyearDiscountField;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Product aaa() {
        Battery p1 = new Battery();
        p1.setName("AAA");
        p1.setPrice(2.5);
        p1.setRechargeable(true);
        p1.setDiscount(specialCustomerDiscountField);
        return p1;
    }

    @Bean
    public Product cdrw() {
        Disc p2 = new Disc("CD-RW", 1.5, specialSummerDiscountField);
        p2.setCapacity(700);
        return p2;
    }

    @Bean
    public Product dvdrw() {
        Disc p2 = new Disc("DVD-RW", 3.0, specialEndofyearDiscountField);
        p2.setCapacity(700);
        return p2;
    }
}

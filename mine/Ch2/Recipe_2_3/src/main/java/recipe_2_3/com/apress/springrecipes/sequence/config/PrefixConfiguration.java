package recipe_2_3.com.apress.springrecipes.sequence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import recipe_2_3.com.apress.springrecipes.sequence.DatePrefixGenerator;
import recipe_2_3.com.apress.springrecipes.sequence.NumberPrefixGenerator;

@Configuration
public class PrefixConfiguration {
    @Bean
    @Primary
    public DatePrefixGenerator datePrefixGenerator(){
        DatePrefixGenerator dpg = new DatePrefixGenerator();
        dpg.setId("1");
        dpg.setPattern("yyyyMMdd");
        return dpg;
    }

    @Bean
    public NumberPrefixGenerator numberPrefixGenerator(){ return new NumberPrefixGenerator(); }

}

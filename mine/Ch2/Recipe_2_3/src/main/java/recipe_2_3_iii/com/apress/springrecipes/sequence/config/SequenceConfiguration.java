package recipe_2_3_iii.com.apress.springrecipes.sequence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import recipe_2_3_i.com.apress.springrecipes.sequence.DatePrefixGenerator;
import recipe_2_3_i.com.apress.springrecipes.sequence.SequenceGenerator;
import recipe_2_3_iii.com.apress.springrecipes.sequence.NumberPrefixGenerator;

@Configuration
public class SequenceConfiguration {

    @Bean
    public DatePrefixGenerator datePrefixGenerator(){
        DatePrefixGenerator dpg = new DatePrefixGenerator();
        dpg.setPattern("yyyyMMdd");
        return dpg;
    }

    @Bean
    public NumberPrefixGenerator numberPrefixGenerator(){ return new NumberPrefixGenerator(); }

    @Bean
    public SequenceGenerator sequenceGenerator(){
        SequenceGenerator sequence = new SequenceGenerator();
        sequence.setInitial(100000);
        sequence.setSuffix("A");
        return sequence;
    }
}

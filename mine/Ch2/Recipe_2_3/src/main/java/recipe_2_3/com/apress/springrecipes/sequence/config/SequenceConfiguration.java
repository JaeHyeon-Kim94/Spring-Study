package recipe_2_3.com.apress.springrecipes.sequence.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import recipe_2_3.com.apress.springrecipes.sequence.*;

@Configuration
@ComponentScan(basePackageClasses = Main.class)
@Import(PrefixConfiguration.class)  //다른 구성 클래스에 정의된 bean들 가져옴.
public class SequenceConfiguration {

    //이 클래스에서 사용할 때.
//    @Value("#{datePrefixGenerator}")
//    private PrefixGenerator datePrefixGenerator;
//
//    @Value("#{numberPrefixGenerator}")
//    private PrefixGenerator numberPrefixGenerator;

    @Bean
    @Primary
    public SequenceGenerator sequenceGenerator(){
        SequenceGenerator sequence = new SequenceGenerator();
        sequence.setInitial(100000);
        sequence.setSuffix("A");
        return sequence;
    }
}

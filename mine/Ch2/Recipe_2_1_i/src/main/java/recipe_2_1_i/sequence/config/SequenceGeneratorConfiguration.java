package recipe_2_1_i.sequence.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import recipe_2_1_i.Main;
import recipe_2_1_i.sequence.SequenceDao;
import recipe_2_1_i.sequence.SequenceDaoImpl;
import recipe_2_1_i.sequence.SequenceGenerator;

//이 클래스가 구성 클래스임을 스프링에 알린다.
@Configuration
/*
    스프링은 @Configuration, @Bean, @Component, @Repository, @Service, @Controller가
    달린 클래스 모두 감지함. 그리고 스캐닝 과정을 커스터마이징을 위한 필터 기능을 제공.
    필터 표현식은 네 종류.
    annotation, assignable은 각각 필터 대상 애너테이션 타입 및 클래스/인터페이스 지정
     나머지 regex, aspectj는 각각 정규 표현식과 AspectJ 포인트컷 표현식으로 클래스 매치.
*/
@ComponentScan(
        //basePackages = "recipe_2_1_i"
        basePackageClasses = Main.class,
        //recipe_2_1_i 패키지 하위는 스캔 대상에 포함
        includeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.REGEX,
                        pattern ={"recipe_2_1_i.Sequence*"})
        },
        //Controller 애너테이션 붙은 클래스는 스캔 대상에서 제외
        excludeFilters = {
                @ComponentScan.Filter(
                        type = FilterType.ANNOTATION,
                        classes = {org.springframework.stereotype.Controller.class}
                )
        }
)
public class SequenceGeneratorConfiguration {
    //name(지정하지 않으면 메서드명)과 동일한 이름의 빈 생성.
    @Bean(name="seqgen1")
    public SequenceGenerator sequenceGenerator(){
        SequenceGenerator seqgen = new SequenceGenerator();
        seqgen.setPrefix("30");
        seqgen.setSuffix("A");
        seqgen.setInitial("10000");
        return seqgen;
    }

    @Bean(name="seqgen2")
    public SequenceDao sequenceDao(){
        return new SequenceDaoImpl();
    }
}

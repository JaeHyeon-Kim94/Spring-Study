package recipe_2_1_i;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import recipe_2_1_i.sequence.SequenceDao;
import recipe_2_1_i.sequence.SequenceGenerator;
import recipe_2_1_i.sequence.config.SequenceGeneratorConfiguration;

public class Main {
    public static void main(String[] args) {
        /*
        애너테이션을 붙인 자바 클래스를 스캔하기 위해선 IoC 컨테이너를 인스턴스화 해야 함.
        스프링은 기본 구현체인 BeanFactory와 고급 구현체인 ApplicationContext 두 가지 IoC 컨테이너를 제공한다.
        ApplicationContext는 BeanFactory의 하위 인터페이스로서 호환성이 보장되며 발전된 기능을 가지므로
        특수한 상황(리소스에 제약)이 아니라면 가급적 ApplicationContext 사용.

        ApplicationContext는 인터페이스이기 때문에 구현체를 이용해야 하는데
        대표적인 구현체는 AnnotationConfigApplicationContext.

        POJO 인스턴스에 액세스하는 창구 역할을 한다.
        */
        ApplicationContext context
                = new AnnotationConfigApplicationContext(SequenceGeneratorConfiguration.class);


        //IoC 컨테이너에서 POJO 인스턴스/빈 가져오기
        //단순히 getBean()으로 호출하면 Object형을 반환하기 때문에
        //캐스팅 생략하려면 두번째 인수에 bean 클래스명 지정
        SequenceGenerator generator = context.getBean("seqgen1", SequenceGenerator.class);
        //(빈이 하나뿐이라면 이름 생략 가능)
        //SequenceGenerator generator = context.getBean(SequenceGenerator.class);

        System.out.println(generator.getSequence());
        System.out.println(generator.getSequence());

        SequenceDao sequenceDao = context.getBean("seqgen2",SequenceDao.class);

        System.out.println(sequenceDao.getNextValue("IT"));
        System.out.println(sequenceDao.getNextValue("IT"));

    }
}

package recipe_2_4_ii;

import javax.inject.Inject;

public class SequenceGenerator {
    /*
    * @Resource와 @Autowired와 마찬가지로 @Inject도 타입으로 POJO를 찾음.
    * 그러나 같은 타입의 POJO가 여럿일 경우 이름을 통해 자동 주입을 하려면
    * 주입 클래스와 주입 지점을 구별하기 위해 커스텀 애너테이션을 작성해야 한다.
    */
    @Inject @DatePrefixAnnotation
    private PrefixGenerator prefixGenerator;
}

package recipe_2_4_i;

import javax.annotation.Resource;


public class SequenceGenerator {
    //@Resource : 자바 표준 애너테이션
    //@Autowired의 경우 같은 타입의 빈이 여럿일 경우 자동 주입이 애매해짐
    //반면 @Resource는 기능상 @Autowired + @Qualifier
    @Resource(name = "DatePrefixGenerator")
    private PrefixGenerator prefixGenerator;
}

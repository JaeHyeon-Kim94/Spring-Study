package recipe_2_4_ii;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Qualifier  //Spring의 @Qualifier와 다르다.
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DatePrefixAnnotation {
}

package recipe_2_3.com.apress.springrecipes.sequence;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import recipe_2_3.com.apress.springrecipes.sequence.config.SequenceConfiguration;

public class Main {
    public static void main(String[] args) {
        ApplicationContext annotationContext =
                new AnnotationConfigApplicationContext(SequenceConfiguration.class);
//        AnnotationConfigApplicationContext annotationContext = new AnnotationConfigApplicationContext();
//        annotationContext.register(SequenceConfiguration.class);
        ApplicationContext xmlContext =
                new GenericXmlApplicationContext("appContext.xml");


        SequenceGenerator generator = annotationContext.getBean(SequenceGenerator.class);
        SequenceGenerator generator1 = annotationContext.getBean("SequenceGeneratorInjectedByComponentAnnotation", SequenceGenerator.class);

        System.out.println("1.. Annotation Context");
        System.out.println("By List : " + generator.getSequenceList());
        System.out.println("By Constructor : " + generator1.getSequenceConstructor());
        System.out.println("By Setter : " + generator.getSequenceSetter());

        generator = generator1 = null;

        generator = xmlContext.getBean(SequenceGenerator.class);
        generator1 = xmlContext.getBean("SequenceGeneratorInjectedByComponentAnnotation", SequenceGenerator.class);

        System.out.println("2.. XML Context");
        System.out.println("By List : " + generator.getSequenceList());
        System.out.println("By Constructor : " + generator1.getSequenceConstructor());
        System.out.println("By Setter : " + generator.getSequenceSetter());
    }
}

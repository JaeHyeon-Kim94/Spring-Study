package recipe_2_3.com.apress.springrecipes.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component(value = "SequenceGeneratorInjectedByComponentAnnotation")

public class SequenceGenerator {


    @Autowired(required = false)
    private List<PrefixGenerator> prefixGenerators;

    private PrefixGenerator prefixGeneratorByConstructor;

    private PrefixGenerator prefixGeneratorBySetter;
    private String suffix;
    private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    public SequenceGenerator() {
    }

    @Autowired
    public SequenceGenerator(@Qualifier("numberPrefixGenerator") PrefixGenerator prefixGeneratorByConstructor) {
        this.prefixGeneratorByConstructor = prefixGeneratorByConstructor;
    }


    @Autowired
    public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
        this.prefixGeneratorBySetter = prefixGenerator;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public String getSequenceList(){
        String builder = prefixGenerators.get(1).getPrefix() +
                initial +
                counter.getAndIncrement() +
                suffix;
        return builder;
    }

    public String getSequenceSetter(){
        String builder = prefixGeneratorBySetter.getPrefix() +
                initial +
                counter.getAndIncrement() +
                suffix;
        return builder;
    }

    public String getSequenceConstructor(){
        String builder = prefixGeneratorByConstructor.getPrefix() +
                initial +
                counter.getAndIncrement() +
                suffix;
        return builder;
    }
}

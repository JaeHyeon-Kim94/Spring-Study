package recipe_2_3_iii.com.apress.springrecipes.sequence;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {

    private PrefixGenerator prefixGenerator;
    private String suffix;
    private int initial;
    private final AtomicInteger counter = new AtomicInteger();

    public SequenceGenerator() {
    }

    public SequenceGenerator(PrefixGenerator prefixGenerator, String suffix, int initial) {
        this.prefixGenerator = prefixGenerator;
        this.suffix = suffix;
        this.initial = initial;
    }
    @Autowired(required = false)
    public void setPrefixGenerator(PrefixGenerator prefixGenerator) {
        this.prefixGenerator = prefixGenerator;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public String getSequence(){
        String builder = prefixGenerator.getPrefix() +
                initial +
                counter.getAndIncrement() +
                suffix;
        return builder;
    }
}

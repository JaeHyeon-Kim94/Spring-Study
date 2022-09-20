package recipe_2_1_i.sequence;

import java.util.concurrent.atomic.AtomicInteger;

public class SequenceGenerator {
    private String prefix;
    private String suffix;
    private String initial;
    private final AtomicInteger counter = new AtomicInteger();

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getSequence(){
        StringBuilder sb = new StringBuilder();

        return sb.append(prefix)
                .append(initial)
                .append(counter.getAndIncrement())
                .append(suffix)
                .toString();

    }
}

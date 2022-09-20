package recipe_2_1_i.sequence;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/*
    스프링이 발견할 수 있게 POJO에 붙이는 범용 애너테이션
    각각 레이어를 가리키는 @Repository, @Service, @Controller 애너테이션이 있음.
    쓰임새가 명확하지 않은 경우를 제외하곤 용도에 맞는 애너테이션 붙여줘야 한다.
*/
@Component("sequenceDao")
public class SequenceDaoImpl implements SequenceDao{

    private final Map<String, Sequence> sequences = new HashMap<>();
    private final Map<String, AtomicInteger> values = new HashMap<>();

    public SequenceDaoImpl() {
        sequences.put("IT", new Sequence("IT", "30", "A"));
        values.put("IT", new AtomicInteger(10000));
    }

    @Override
    public Sequence getSequence(String sequenceId) {
        return sequences.get(sequenceId);
    }

    @Override
    public int getNextValue(String sequenceId) {
        AtomicInteger value = values.get(sequenceId);
        return value.getAndIncrement();
    }
}

package recipe_2_3_ii.com.apress.springrecipes.sequence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SequenceService {


    /*
       배열형 프로퍼티에 @Autowired를 붙이면 스프링은 매치된 빈을 모두 찾아 자동으로 연결한다.
       ex1)
       @Autowired
       private PrefixGenerator[] prefixGenerators;
       이 경우 PrefixGenerator 타입과 호환되는 빈을 한 번에 모두 찾아 자동으로 연결한다.

       ex2)
       @Autowired
       private List<PrefixGenerator> prefixGenerators;

       @Autowired
       private Map<String, PrefixGenerator> prefixGenerators;
       이 경우 빈의 이름이 key가 됨.
   */
    @Autowired
    private SequenceDao sequenceDao;

    public SequenceService() {
    }

    public SequenceService(SequenceDao sequenceDao) {
        this.sequenceDao = sequenceDao;
    }

    public void setSequenceDao(SequenceDao sequenceDao) {
        this.sequenceDao = sequenceDao;
    }

    public String generate(String sequenceId){
        Sequence sequence = sequenceDao.getSequence(sequenceId);
        int value = sequenceDao.getNextValue(sequenceId);
        return sequence.getPrefix() + value + sequence.getSuffix();
    }
}

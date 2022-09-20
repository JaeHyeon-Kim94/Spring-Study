package recipe_2_1_i.sequence;

//DB 데이터 액세스를 처리하는 DAO 인터페이스
public interface SequenceDao {
    public Sequence getSequence(String sequenceId);
    public int getNextValue(String sequenceId);
}

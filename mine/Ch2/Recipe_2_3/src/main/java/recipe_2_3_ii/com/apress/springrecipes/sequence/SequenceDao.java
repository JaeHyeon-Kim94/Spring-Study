package recipe_2_3_ii.com.apress.springrecipes.sequence;

public interface SequenceDao {
    public Sequence getSequence(String sequenceId);
    public int getNextValue(String sequenceId);
}

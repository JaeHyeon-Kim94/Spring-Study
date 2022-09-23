package recipe_2_3_iii.com.apress.springrecipes.sequence;

import recipe_2_3_i.com.apress.springrecipes.sequence.PrefixGenerator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatePrefixGenerator implements PrefixGenerator {

    private DateFormat formatter;

    public void setPattern(String pattern){
        this.formatter = new SimpleDateFormat(pattern);
    }

    public String getPrefix(){
        return formatter.format(new Date());
    }
}

package recipe_2_3.com.apress.springrecipes.sequence;

import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

//@Component
public class DatePrefixGenerator implements PrefixGenerator {

    private String id;
    private DateFormat formatter;

    public void setId(String id) {
        this.id = id;
    }

    public void setPattern(String pattern){
        this.formatter = new SimpleDateFormat(pattern);
    }

    public String getPrefix(){
        return this.id + " :: " +formatter.format(new Date());
    }

    @Override
    public String toString() {
        return "DatePrefixGenerator{" +
                "id='" + id + '\'' +
                ", formatter=" + formatter +
                '}';
    }
}

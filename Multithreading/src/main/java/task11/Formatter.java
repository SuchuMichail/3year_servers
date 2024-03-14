package task11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {
    private ThreadLocal<SimpleDateFormat> sdf;
    public Formatter(ThreadLocal<SimpleDateFormat> sdf){
        this.sdf = sdf;
    }

    public String format(Date date){
        return sdf.get().format(date);
    }

}

package task11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Formatter {
    private ThreadLocal<SimpleDateFormat> sdf;
    public Formatter(ThreadLocal<SimpleDateFormat> sdf){
        this.sdf = sdf;
    }

    public ThreadLocal<SimpleDateFormat> getThreadLocalSDF(){
        return sdf;
    }

    public String format(Date date){
        return sdf.get().format(date);
    }
}

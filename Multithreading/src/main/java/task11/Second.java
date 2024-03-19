package task11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Second extends Thread {
    private final Formatter formatter;
    private final Date date;

    public Second(Formatter formatter, Date date) {
        this.formatter = formatter;
        this.date = date;
    }

    @Override
    public void run() {
        formatter.getThreadLocalSDF().set(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"));
        System.out.println("second " + formatter.format(date));
    }
}
package task11;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class Second extends Thread {
    private final ThreadLocal<SimpleDateFormat> threadLocal;
    private final Formatter formatter;
    private final Date date;

    public Second(ThreadLocal<SimpleDateFormat> threadLocal, Formatter formatter, Date date) {
        this.threadLocal = threadLocal;
        this.formatter = formatter;
        this.date = date;
    }

    @Override
    public void run() {
        threadLocal.set(new SimpleDateFormat("dd-MM-yyyy HH:mm:ss"));
        System.out.println("second " + formatter.format(date));
    }
}
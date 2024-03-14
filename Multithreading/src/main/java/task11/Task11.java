package task11;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;

public class Task11 {
    public static void main(String[] args){
        ThreadLocal<SimpleDateFormat> localVariable = new ThreadLocal<>();
        Formatter formatter = new Formatter(localVariable);

        Date firstDate = new Date(124, 2,  1, 11, 1, 1);
        Date secondDate = new Date(124, 2,  2, 12, 2, 2);
        Date thirdDate = new Date(124, 2,  3, 13, 3, 3);
        Date fourthDate = new Date(124, 2,  4, 14, 4, 4);
        Date fifthDate = new Date(124, 2,  5, 15, 5, 5);

        Thread first = new First(localVariable, formatter, firstDate);
        Thread second = new Second(localVariable, formatter, secondDate);
        Thread third = new Third(localVariable, formatter, thirdDate);
        Thread fourth = new Fourth(localVariable, formatter, fourthDate);
        Thread fifth = new Fifth(localVariable, formatter, fifthDate);

        first.start();
        second.start();
        third.start();
        fourth.start();
        fifth.start();

    }
}

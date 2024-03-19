package task11;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task11 {
    public static void main(String[] args){
        ThreadLocal<SimpleDateFormat> localVariable = new ThreadLocal<>();
        Formatter formatter = new Formatter(localVariable);

        Date firstDate = new Date(124, 0,  1, 11, 1, 1);
        Date secondDate = new Date(124, 1,  2, 12, 2, 2);
        Date thirdDate = new Date(124, 2,  3, 13, 3, 3);
        Date fourthDate = new Date(124, 3,  4, 14, 4, 4);
        Date fifthDate = new Date(124, 4,  5, 15, 5, 5);

        Thread first = new First(formatter, firstDate);
        Thread second = new Second(formatter, secondDate);
        Thread third = new Third(formatter, thirdDate);
        Thread fourth = new Fourth(formatter, fourthDate);
        Thread fifth = new Fifth(formatter, fifthDate);

        first.start();
        second.start();
        third.start();
        fourth.start();
        fifth.start();

    }
}

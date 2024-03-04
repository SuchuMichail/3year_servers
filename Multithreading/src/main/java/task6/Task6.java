package task6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task6 {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> arrayList3 = new ArrayList<>();
        arrayList3 = Collections.synchronizedList(arrayList3);

        TwoMethodsWithSynchList flow1 = new TwoMethodsWithSynchList(arrayList3, true, 10_000);
        TwoMethodsWithSynchList flow2 = new TwoMethodsWithSynchList(arrayList3, false, 10_000);

        flow1.start();
        flow2.start();

        flow1.join();
        flow2.join();

        System.out.println("\nЗапустили два потока на базе одного класса\n" +
                "Они поработали с листом. И теперь лист имеет размер = " + arrayList3.size() + "\n");

    }
}

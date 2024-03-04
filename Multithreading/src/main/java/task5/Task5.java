package task5;

import java.util.ArrayList;

public class Task5 {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        CommonResource resource = new CommonResource(arrayList2);

        Thread flow1 = new TwoSynchronizedMethods(resource,10_000,true);
        Thread flow2 = new TwoSynchronizedMethods(resource,10_000,false);

        flow1.start();
        flow2.start();

        flow1.join();
        flow2.join();

        System.out.println("\nЗапустили два потока на базе одного класса\n" +
                "Они поработали с листом. И теперь лист имеет размер = " + arrayList2.size() + "\n");

    }
}

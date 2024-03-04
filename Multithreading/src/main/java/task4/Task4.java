package task4;

import java.util.ArrayList;

public class Task4
{
    public static void main( String[] args ) throws InterruptedException {
        ArrayList<Integer> arrayList = new ArrayList<>();

        Thread first = new AdderRandomInt(arrayList, 10_000);
        Thread second = new DeleterFromRandomIndex(arrayList, 10_000);

        first.start();
        second.start();

        first.join();
        second.join();

        System.out.println("Запустили два потока на базе двух разных классов\n" +
                "Они поработали с листом. И теперь лист имеет размер = " + arrayList.size() + "\n");

    }
}

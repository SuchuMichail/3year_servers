package task10;

public class TestRemover {
    public static void main(String[] args) throws InterruptedException {
        MyConcurrentHashMap<Integer,String> map = new MyConcurrentHashMap<>();
        map.put(3,"third");
        map.put(3,"second");
        map.put(1,"first");

        Thread firstRemover = new Remover<>(map,1);
        Thread secondRemover = new Remover<>(map,2);
        Thread thirdRemover = new Remover<>(map,3);

        firstRemover.start();
        secondRemover.start();
        thirdRemover.start();

        firstRemover.join();
        secondRemover.join();
        thirdRemover.join();

        System.out.println();

        String res1 = map.get(1);
        String res2 = map.get(2);
        String res3 = map.get(3);
    }
}

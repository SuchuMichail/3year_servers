package task10;

public class TestPutter {
    public static void main(String[] args) throws InterruptedException {
        MyConcurrentHashMap<Integer,String> map = new MyConcurrentHashMap<>();
        Thread firstPutter = new Putter<>(map,3,"first");
        Thread secondPutter = new Putter<>(map,1,"second");
        Thread thirdPutter = new Putter<>(map,1,"third");

        firstPutter.start();
        secondPutter.start();
        thirdPutter.start();

        firstPutter.join();
        secondPutter.join();
        thirdPutter.join();

        System.out.println();

        String res1 = map.get(1);
        String res2 = map.get(2);
        String res3 = map.get(3);
    }
}

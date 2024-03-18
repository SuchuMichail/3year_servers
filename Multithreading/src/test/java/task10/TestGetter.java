package task10;

public class TestGetter {
    public static void main(String[] args){
        MyConcurrentHashMap<Integer,String> map = new MyConcurrentHashMap<>();
        map.put(3,"third");
        map.put(3,"second");
        map.put(1,"first");

        Thread firstGetter = new Getter<>(map,1);
        Thread secondGetter = new Getter<>(map,2);
        Thread thirdGetter = new Getter<>(map,3);

        firstGetter.start();
        secondGetter.start();
        thirdGetter.start();
    }
}

package task13;

public class Data {
    private final int[] data;

    public Data(int[] data) {
        this.data = data;
    }

    public int[] get() {
        return data;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int datum : data) {
            res.append(datum).append(" ");
        }
        return res.toString();
    }
}

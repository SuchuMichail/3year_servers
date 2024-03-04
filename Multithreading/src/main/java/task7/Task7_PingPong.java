package task7;

public class Task7_PingPong {
    public static void main(String[] args){
        PingPongMessage message = new PingPongMessage("");
        Thread ping = new Ping(message);
        Thread pong = new Pong(message);

        ping.start();
        pong.start();
    }
}

package task7;

public class Ping extends Thread {
    private final String string_ping = "ping";
    private final PingPongMessage message;
    public Ping(PingPongMessage message){
        this.message = message;
    }
    @Override
    public void run(){
        while(true) {
            synchronized (message) {
                if (message.getMessage().equals(string_ping)) {
                    try {
                        message.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                message.setMessage(string_ping);
                message.printMessage();
                message.notify();
            }
        }
    }
}

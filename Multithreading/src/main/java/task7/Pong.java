package task7;

public class Pong extends Thread {
    private final String string_pong = "        pong";
    private final PingPongMessage message;
    public Pong(PingPongMessage message){
        this.message = message;
    }
    @Override
    public void run(){
        while(true) {
            synchronized (message) {
                if (message.getMessage().equals(string_pong)) {
                    try {
                        message.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                message.setMessage(string_pong);
                message.printMessage();
                message.notify();
            }
        }
    }
}

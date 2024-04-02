package task12;

import java.util.HashMap;

public class TransportArrayOfMessages extends Thread {
    private final Message[] array;
    private final Transport transport;

    public TransportArrayOfMessages(HashMap<String,Position> mappa, String filename, Message[] array) {
        this.array = array;
        this.transport = new Transport(filename, mappa);
    }

    @Override
    public void run() {
        for (Message message : array) {
            transport.send(message);
        }
    }
}

package task12;

public class TransportArrayOfMessages extends Thread {
    private final Message[] array;
    private final Transport transport;

    public TransportArrayOfMessages(String filename, Message[] array) {
        this.array = array;
        this.transport = new Transport(filename, array.length);
    }

    @Override
    public void run() {
        for (Message message : array) {
            transport.send(message);
        }
    }
}

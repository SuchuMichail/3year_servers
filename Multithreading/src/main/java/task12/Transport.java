package task12;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Transport {
    private final String filename;
    private final Position[] positionMessages;

    private class WritterThread extends Thread {
        private static final String folder = "src/main/java/task12/";
        private final Message message;

        private WritterThread(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            int pos = Math.abs(filename.hashCode()) % positionMessages.length;

            positionMessages[pos].getLocker().lock();

            int currentPosition = positionMessages[pos].getPosition();
            positionMessages[pos].setPosition(positionMessages[pos].getPosition() + message.getSize());

            positionMessages[pos].getLocker().unlock();

            File file = new File(folder + filename);
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try (RandomAccessFile fw = new RandomAccessFile(file, "rw")) {
                fw.seek(currentPosition);
                fw.write(message.toString().getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public Transport(String filename, Position[] positionMessages) {
        this.filename = filename;
        this.positionMessages = positionMessages;
    }

    public void send(Message message) {
        WritterThread thread = new WritterThread(message);
        thread.start();
    }
}

package task12;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class Transport {
    private final String filename;
    private final HashMap<String,Position> mappa;

    private class WritterThread extends Thread {
        private static final String folder = "src/main/java/task12/";
        private final Message message;

        private WritterThread(Message message) {
            this.message = message;
        }

        @Override
        public void run() {
            Position position = mappa.get(filename);
            position.getLocker().lock();

            int currentPosition = position.getPosition();
            position.setPosition(currentPosition + message.getSize());

            position.getLocker().unlock();

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

    public Transport(String filename, HashMap<String,Position> mappa) {
        this.filename = filename;
        this.mappa = mappa;
    }

    public void send(Message message) {
        WritterThread thread = new WritterThread(message);
        thread.start();
    }
}

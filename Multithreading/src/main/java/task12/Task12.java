package task12;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Task12 {
    public static List<String> readEmails(String filename) {
        List<String> emails = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filename))) {
            String str;
            while ((str = reader.readLine()) != null) {
                emails.add(str);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return emails;
    }

    public static void main(String[] args) {
        List<String> emails = readEmails("src/main/java/task12/emails.txt");

        HashMap<String, Position> mappa = new HashMap<>(emails.size());
        for (int i = 0; i < emails.size(); i++) {
            Position position = new Position(0);
            mappa.put(emails.get(i), position);
        }

        Message message1_1 = new Message("Sen1_1", "Su1_1", "Bo1_1");
        Message message1_2 = new Message("Sen1_2", "Su1_2", "Bo1_2");
        Message message1_3 = new Message("Sen1_3", "Su1_3", "Bo1_3");
        Message message2_1 = new Message("Sen2_1", "Su2_1", "Bo2_1");
        Message message2_2 = new Message("Sen2_2", "Su2_2", "Bo2_2");
        Message message2_3 = new Message("Sen2_3", "Su2_3", "Bo2_3");
        Message message3_1 = new Message("Sen3_1", "Su3_1", "Bo3_1");
        Message message3_2 = new Message("Sen3_2", "Su3_2", "Bo3_2");
        Message message3_3 = new Message("Sen3_3", "Su3_3", "Bo3_3");

        Thread transport1 = new TransportArrayOfMessages(mappa, emails.get(0), new Message[]{message1_1, message1_2, message1_3});
        Thread transport2 = new TransportArrayOfMessages(mappa, emails.get(0), new Message[]{message2_1, message2_2, message2_3});
        Thread transport3 = new TransportArrayOfMessages(mappa, emails.get(2), new Message[]{message3_1, message3_2, message3_3});

        transport1.start();
        transport2.start();
        transport3.start();
    }
}

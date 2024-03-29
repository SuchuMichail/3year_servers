package task12;

public class Message {
    private final String sender;
    private final String subject;
    private final String body;

    public Message(String sender, String subject, String body) {
        this.sender = sender;
        this.subject = subject;
        this.body = body;
    }

    public int getSize(){
        return toString().length();
    }

    @Override
    public String toString(){
        return "\n**********\nSender: " + sender + "\nSubject: " + subject + "\nBody: " + body + "\n**********\n";
    }
}

package task7;

public class PingPongMessage {
    private String message;

    public PingPongMessage(String message){
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage(){
        System.out.println(message);
    }
}

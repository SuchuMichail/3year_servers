package repositories.exceptions;

public class AttendanceRepositoryException extends Exception {
    private final String _message = "AttendanceRepositoryException";

    @Override
    public String getMessage(){
        return _message;
    }
}

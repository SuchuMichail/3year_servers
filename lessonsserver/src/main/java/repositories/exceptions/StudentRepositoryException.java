package repositories.exceptions;

public class StudentRepositoryException extends Exception {
    private final String _message = "StudentRepositoryException";

    @Override
    public String getMessage(){
        return _message;
    }
}

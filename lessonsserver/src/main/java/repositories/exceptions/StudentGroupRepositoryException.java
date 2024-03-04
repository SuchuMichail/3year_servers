package repositories.exceptions;

public class StudentGroupRepositoryException extends Exception {
    private final String _message = "StudentGroupRepositoryException";

    @Override
    public String getMessage(){
        return _message;
    }
}

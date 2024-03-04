package repositories.exceptions;

public class SubjectRepositoryException extends Exception {
    private final String _message = "SubjectRepositoryException";

    @Override
    public String getMessage(){
        return _message;
    }
}

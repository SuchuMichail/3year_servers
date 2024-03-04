package repositories.exceptions;

public class LessonRepositoryException extends Exception {
    private final String _message = "LessonRepositoryException";

    @Override
    public String getMessage(){
        return _message;
    }
}

package repositories.exceptions;

public class TeacherRepositoryException extends Exception {
    private final String _message = "TeacherRepositoryException";

    @Override
    public String getMessage(){
        return _message;
    }
}

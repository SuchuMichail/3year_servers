package services.exceptions.students;

public class AddStudentServiceException extends Exception{
    private final String _message = "AddStudentException";

    public AddStudentServiceException(Throwable cause) {
        super(cause);
    }

    @Override
    public String getMessage() {
        return _message;
    }
}

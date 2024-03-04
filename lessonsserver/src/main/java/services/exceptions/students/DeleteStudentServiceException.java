package services.exceptions.students;

public class DeleteStudentServiceException extends Exception{
    private final String _message = "DeleteStudentException";

    @Override
    public String getMessage(){
        return _message;
    }
}

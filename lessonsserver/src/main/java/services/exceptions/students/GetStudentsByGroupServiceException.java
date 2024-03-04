package services.exceptions.students;

public class GetStudentsByGroupServiceException extends Exception{
    private final String _message = "GetStudentsByGroupServiceException";

    @Override
    public String getMessage(){
        return _message;
    }
}

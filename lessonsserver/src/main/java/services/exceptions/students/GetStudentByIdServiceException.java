package services.exceptions.students;

public class GetStudentByIdServiceException extends Exception{
    private final String _message = "GetStudentByIdException";

    @Override
    public String getMessage(){
        return _message;
    }
}

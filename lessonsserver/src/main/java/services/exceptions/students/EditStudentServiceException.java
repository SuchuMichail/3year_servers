package services.exceptions.students;

public class EditStudentServiceException extends Exception{
    private final String _message = "EditStudentException";

    @Override
    public String getMessage(){
        return _message;
    }

}

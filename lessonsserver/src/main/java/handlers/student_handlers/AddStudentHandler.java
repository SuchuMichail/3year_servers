package handlers.student_handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentController;
import requests.students.AddStudentRequest;
import handlers.IHandler;


public class AddStudentHandler implements IHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    //private final DataBase base = new DataBase();
    //private final IStudentService service = new StudentService(base);
    //private final ValidatorAddStudentRequest validatorAddStudentRequest = new ValidatorAddStudentRequest();

    //private StudentController controller = new StudentController(service);

    private final StudentController controller;
    public AddStudentHandler(StudentController controller){
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws JsonProcessingException {
        AddStudentRequest request = objectMapper.readValue(json, AddStudentRequest.class);

        return objectMapper.writeValueAsString(controller.addStudent(request));
        //по json создадим студента, получим от контроллера респонс, потом его сериализуем и возвращаем
    }

}

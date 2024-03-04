package handlers.student_handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentController;
import requests.students.EditStudentRequest;
import handlers.IHandler;

public class EditStudentHandler implements IHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final StudentController controller;

    public EditStudentHandler(StudentController controller){
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws JsonProcessingException {
        EditStudentRequest request = objectMapper.readValue(json, EditStudentRequest.class);

        return objectMapper.writeValueAsString(controller.editStudent(request));
    }
}

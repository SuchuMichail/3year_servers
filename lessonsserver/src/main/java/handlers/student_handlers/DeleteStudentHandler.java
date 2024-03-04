package handlers.student_handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentController;
import requests.students.DeleteStudentRequest;
import handlers.IHandler;

public class DeleteStudentHandler implements IHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final StudentController controller;

    public DeleteStudentHandler(StudentController controller){
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws JsonProcessingException {
        DeleteStudentRequest request = objectMapper.readValue(json, DeleteStudentRequest.class);

        return objectMapper.writeValueAsString(controller.deleteStudent(request));
    }
}

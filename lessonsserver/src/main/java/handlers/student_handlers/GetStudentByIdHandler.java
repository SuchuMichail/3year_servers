package handlers.student_handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentController;
import requests.students.GetStudentByIdRequest;
import handlers.IHandler;

public class GetStudentByIdHandler implements IHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final StudentController controller;

    public GetStudentByIdHandler(StudentController controller){
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws JsonProcessingException {
        GetStudentByIdRequest request = objectMapper.readValue(json, GetStudentByIdRequest.class);

        return objectMapper.writeValueAsString(controller.getStudentById(request));
    }
}

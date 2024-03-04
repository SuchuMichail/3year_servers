package handlers.student_handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.StudentController;
import requests.students.GetStudentsByGroupRequest;
import handlers.IHandler;

public class GetStudentsByGroupHandler implements IHandler {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final StudentController controller;

    public GetStudentsByGroupHandler(StudentController controller){
        this.controller = controller;
    }

    @Override
    public String handle(String json) throws JsonProcessingException {
        GetStudentsByGroupRequest request = objectMapper.readValue(json, GetStudentsByGroupRequest.class);

        return objectMapper.writeValueAsString(controller.getStudentsByGroup(request));
    }
}

package services.interfaces;

import exceptions.service_exceptions.NotFoundService;
import exceptions.service_exceptions.ServiceException;
import requests.students.*;
import responses.students.AddStudentResponse;
import responses.students.GetStudentByIdResponse;

import java.util.List;

public interface IStudentService {
    AddStudentResponse addStudent(AddStudentRequest request) throws NotFoundService;
    GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) throws NotFoundService;
    void deleteStudentById(DeleteStudentRequest request) throws NotFoundService;
    void editStudent(EditStudentRequest request) throws ServiceException;
    List<GetStudentByIdResponse> getStudentsByGroup(GetStudentsByGroupRequest request) throws NotFoundService;
}

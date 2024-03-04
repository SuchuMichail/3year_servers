package services;

import repositories.exceptions.StudentRepositoryException;
import requests.students.*;
import responses.students.AddStudentResponse;
import responses.students.GetStudentByIdResponse;
import services.exceptions.students.*;

import java.util.List;

public interface IStudentService {
    AddStudentResponse addStudent(AddStudentRequest request) throws AddStudentServiceException;
    GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) throws GetStudentByIdServiceException;
    void deleteStudent(DeleteStudentRequest request) throws DeleteStudentServiceException;
    void editStudent(EditStudentRequest request) throws EditStudentServiceException;
    List<GetStudentByIdResponse> getStudentsByGroup(GetStudentsByGroupRequest request) throws GetStudentsByGroupServiceException;
}

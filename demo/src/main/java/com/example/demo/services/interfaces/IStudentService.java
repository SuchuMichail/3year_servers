package com.example.demo.services.interfaces;

import com.example.demo.exceptions.service_exceptions.NotFoundService;
import com.example.demo.exceptions.service_exceptions.ServiceException;
import com.example.demo.requests.students.*;
import com.example.demo.responses.students.AddStudentResponse;
import com.example.demo.responses.students.GetStudentByIdResponse;

import java.util.List;

public interface IStudentService {
    AddStudentResponse addStudent(AddStudentRequest request) throws NotFoundService;
    GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) throws NotFoundService;
    void deleteStudentById(DeleteStudentRequest request) throws NotFoundService;
    void editStudent(EditStudentRequest request) throws ServiceException;
    List<GetStudentByIdResponse> getStudentsByGroup(GetStudentsByGroupRequest request) throws NotFoundService;
}

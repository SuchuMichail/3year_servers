package com.example.demo.services.interfaces;

import com.example.demo.exceptions.service_exceptions.NotFoundService;
import com.example.demo.exceptions.service_exceptions.ServiceException;
import com.example.demo.requests.teachers.AddTeacherRequest;
import com.example.demo.requests.teachers.DeleteTeacherRequest;
import com.example.demo.requests.teachers.EditTeacherRequest;
import com.example.demo.requests.teachers.GetTeacherByIdRequest;
import com.example.demo.responses.teachers.AddTeacherResponse;
import com.example.demo.responses.teachers.GetTeacherByIdResponse;

import java.util.List;

public interface ITeacherService {
    AddTeacherResponse add(AddTeacherRequest request);

    void delete(DeleteTeacherRequest request) throws NotFoundService;

    void edit(EditTeacherRequest request) throws ServiceException;

    GetTeacherByIdResponse getById(GetTeacherByIdRequest request) throws NotFoundService;

    List<GetTeacherByIdResponse> getAllTeachers();
}

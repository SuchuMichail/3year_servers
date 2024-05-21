package services.interfaces;

import exceptions.service_exceptions.NotFoundService;
import exceptions.service_exceptions.ServiceException;
import requests.teachers.AddTeacherRequest;
import requests.teachers.DeleteTeacherRequest;
import requests.teachers.EditTeacherRequest;
import requests.teachers.GetTeacherByIdRequest;
import responses.teachers.AddTeacherResponse;
import responses.teachers.GetTeacherByIdResponse;

import java.util.List;

public interface ITeacherService {
    AddTeacherResponse add(AddTeacherRequest request);

    void delete(DeleteTeacherRequest request) throws NotFoundService;

    void edit(EditTeacherRequest request) throws ServiceException;

    GetTeacherByIdResponse getById(GetTeacherByIdRequest request) throws NotFoundService;

    List<GetTeacherByIdResponse> getAllTeachers();
}

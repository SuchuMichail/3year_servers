package services.interfaces;

import exceptions.service_exceptions.NotFoundService;
import exceptions.service_exceptions.ServiceException;
import requests.lessons.*;
import responses.lessons.AddLessonResponse;
import responses.lessons.GetLessonByIdResponse;

import java.util.List;

public interface ILessonService {
    AddLessonResponse add(AddLessonRequest request) throws ServiceException;

    void delete(DeleteLessonRequest request) throws NotFoundService;

    void edit(EditLessonRequest request) throws ServiceException;

    GetLessonByIdResponse getById(GetLessonByIdRequest request) throws NotFoundService;

    List<GetLessonByIdResponse> getByGroup(GetLessonsByGroupRequest request) throws ServiceException;

    List<GetLessonByIdResponse> getByTeacher(GetLessonsByTeacherRequest request) throws ServiceException;
}

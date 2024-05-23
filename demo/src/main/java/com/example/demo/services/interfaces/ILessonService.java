package com.example.demo.services.interfaces;

import com.example.demo.exceptions.service_exceptions.NotFoundService;
import com.example.demo.exceptions.service_exceptions.ServiceException;
import com.example.demo.requests.lessons.*;
import com.example.demo.responses.lessons.AddLessonResponse;
import com.example.demo.responses.lessons.GetLessonByIdResponse;

import java.util.List;

public interface ILessonService {
    AddLessonResponse add(AddLessonRequest request) throws ServiceException;

    void delete(DeleteLessonRequest request) throws NotFoundService;

    void edit(EditLessonRequest request) throws ServiceException;

    GetLessonByIdResponse getById(GetLessonByIdRequest request) throws NotFoundService;

    List<GetLessonByIdResponse> getByGroup(GetLessonsByGroupRequest request) throws ServiceException;

    List<GetLessonByIdResponse> getByTeacher(GetLessonsByTeacherRequest request) throws ServiceException;
}

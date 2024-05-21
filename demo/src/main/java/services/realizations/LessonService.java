package services.realizations;

import exceptions.service_exceptions.NotFoundService;
import exceptions.service_exceptions.ServiceException;
import org.springframework.stereotype.Service;
import requests.lessons.*;
import responses.lessons.AddLessonResponse;
import responses.lessons.GetLessonByIdResponse;
import services.interfaces.ILessonService;

import java.util.List;

@Service
public class LessonService implements ILessonService {
    @Override
    public AddLessonResponse add(AddLessonRequest request) throws ServiceException {
        return null;
    }

    @Override
    public void delete(DeleteLessonRequest request) throws NotFoundService {

    }

    @Override
    public void edit(EditLessonRequest request) throws ServiceException {

    }

    @Override
    public GetLessonByIdResponse getById(GetLessonByIdRequest request) throws NotFoundService {
        return null;
    }

    @Override
    public List<GetLessonByIdResponse> getByGroup(GetLessonsByGroupRequest request) throws ServiceException {
        return null;
    }

    @Override
    public List<GetLessonByIdResponse> getByTeacher(GetLessonsByTeacherRequest request) throws ServiceException {
        return null;
    }
}

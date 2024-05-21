package services.interfaces;

import exceptions.service_exceptions.NotFoundService;
import exceptions.service_exceptions.ServiceException;
import requests.subjects.AddSubjectRequest;
import requests.subjects.DeleteSubjectRequest;
import requests.subjects.EditSubjectRequest;
import requests.subjects.GetSubjectByIdRequest;
import responses.subjects.AddSubjectResponse;
import responses.subjects.GetSubjectByIdResponse;

import java.util.List;

public interface ISubjectService {
    AddSubjectResponse add(AddSubjectRequest request) throws NotFoundService;

    void delete(DeleteSubjectRequest request) throws NotFoundService;

    void edit(EditSubjectRequest request) throws ServiceException;

    GetSubjectByIdResponse getById(GetSubjectByIdRequest request) throws NotFoundService;

    List<GetSubjectByIdResponse> getAllSubjects();
}

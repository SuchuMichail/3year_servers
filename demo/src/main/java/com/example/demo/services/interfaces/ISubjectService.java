package com.example.demo.services.interfaces;

import com.example.demo.exceptions.service_exceptions.NotFoundService;
import com.example.demo.exceptions.service_exceptions.ServiceException;
import com.example.demo.requests.subjects.AddSubjectRequest;
import com.example.demo.requests.subjects.DeleteSubjectRequest;
import com.example.demo.requests.subjects.EditSubjectRequest;
import com.example.demo.requests.subjects.GetSubjectByIdRequest;
import com.example.demo.responses.subjects.AddSubjectResponse;
import com.example.demo.responses.subjects.GetSubjectByIdResponse;

import java.util.List;

public interface ISubjectService {
    AddSubjectResponse add(AddSubjectRequest request) throws NotFoundService;

    void delete(DeleteSubjectRequest request) throws NotFoundService;

    void edit(EditSubjectRequest request) throws ServiceException;

    GetSubjectByIdResponse getById(GetSubjectByIdRequest request) throws NotFoundService;

    List<GetSubjectByIdResponse> getAllSubjects();
}

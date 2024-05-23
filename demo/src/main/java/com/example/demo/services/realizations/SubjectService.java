package com.example.demo.services.realizations;

import com.example.demo.entities.Subject;
import com.example.demo.exceptions.service_exceptions.NotFoundService;
import com.example.demo.exceptions.service_exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.ISubjectRepository;
import com.example.demo.requests.subjects.AddSubjectRequest;
import com.example.demo.requests.subjects.DeleteSubjectRequest;
import com.example.demo.requests.subjects.EditSubjectRequest;
import com.example.demo.requests.subjects.GetSubjectByIdRequest;
import com.example.demo.responses.subjects.AddSubjectResponse;
import com.example.demo.responses.subjects.GetSubjectByIdResponse;
import com.example.demo.services.interfaces.ISubjectService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements ISubjectService {
    @Autowired
    private ISubjectRepository subjectRepository;

    @Override
    public AddSubjectResponse add(AddSubjectRequest request) throws NotFoundService {
        Subject subject = new Subject(null, request.getName());

        Subject saved = subjectRepository.save(subject);

        return new AddSubjectResponse(saved.getId());
    }

    @Override
    public void delete(DeleteSubjectRequest request) throws NotFoundService {
        subjectRepository.findById(request.getId()).orElseThrow(()->new NotFoundService("invalid subject id"));
        subjectRepository.deleteById(request.getId());
    }

    @Override
    public void edit(EditSubjectRequest request) throws ServiceException {
        subjectRepository.findById(request.getId()).orElseThrow(()->new ServiceException("invalid subject id"));

        subjectRepository.update(request.getName(), request.getId());
    }

    @Override
    public GetSubjectByIdResponse getById(GetSubjectByIdRequest request) throws NotFoundService {
        subjectRepository.findById(request.getId()).orElseThrow(()->new NotFoundService("invalid subject id"));

        Optional<Subject> subject = subjectRepository.findById(request.getId());

        return new GetSubjectByIdResponse(subject.orElseThrow(()->new NotFoundService("invalid subject id")));
    }

    @Override
    public List<GetSubjectByIdResponse> getAllSubjects() {
        List<Subject> list = subjectRepository.findAll();
        List<GetSubjectByIdResponse> result = new ArrayList<>(list.size());
        for(Subject subject: list){
            result.add(new GetSubjectByIdResponse(subject));
        }
        return result;
    }
}

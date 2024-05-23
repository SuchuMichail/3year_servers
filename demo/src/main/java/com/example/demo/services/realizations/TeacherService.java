package com.example.demo.services.realizations;

import com.example.demo.entities.Teacher;
import com.example.demo.exceptions.service_exceptions.NotFoundService;
import com.example.demo.exceptions.service_exceptions.ServiceException;
import com.example.demo.services.interfaces.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.ITeacherRepository;
import com.example.demo.requests.teachers.AddTeacherRequest;
import com.example.demo.requests.teachers.DeleteTeacherRequest;
import com.example.demo.requests.teachers.EditTeacherRequest;
import com.example.demo.requests.teachers.GetTeacherByIdRequest;
import com.example.demo.responses.teachers.AddTeacherResponse;
import com.example.demo.responses.teachers.GetTeacherByIdResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {
    @Autowired
    private ITeacherRepository teacherRepository;

    @Override
    public AddTeacherResponse add(AddTeacherRequest request) {
        Teacher teacher = new Teacher(null, request.getLastName(),request.getFirstName(),request.getMiddleName());

        Teacher saved = teacherRepository.save(teacher);

        return new AddTeacherResponse(saved.getId());
    }

    @Override
    public void delete(DeleteTeacherRequest request) throws NotFoundService {
        teacherRepository.findById(request.getId()).orElseThrow(()->new NotFoundService("invalid teacher id"));
        teacherRepository.deleteById(request.getId());
    }

    @Override
    public void edit(EditTeacherRequest request) throws ServiceException {
        teacherRepository.findById(request.getId()).orElseThrow(()->new ServiceException("invalid teacher id"));

        teacherRepository.update(request.getLastName(), request.getFirstName(), request.getMiddleName(), request.getId());
    }

    @Override
    public GetTeacherByIdResponse getById(GetTeacherByIdRequest request) throws NotFoundService {
        teacherRepository.findById(request.getId()).orElseThrow(()->new NotFoundService("invalid teacher id"));

        Optional<Teacher> teacher = teacherRepository.findById(request.getId());

        return new GetTeacherByIdResponse(teacher.orElseThrow(()->new NotFoundService("invalid teacher id")));
    }

    @Override
    public List<GetTeacherByIdResponse> getAllTeachers() {
        List<Teacher> list = teacherRepository.findAll();
        List<GetTeacherByIdResponse> result = new ArrayList<>(list.size());
        for(Teacher teacher: list){
            result.add(new GetTeacherByIdResponse(teacher));
        }
        return result;
    }
}

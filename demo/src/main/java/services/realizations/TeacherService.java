package services.realizations;

import entities.Subject;
import entities.Teacher;
import exceptions.service_exceptions.NotFoundService;
import exceptions.service_exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ITeacherRepository;
import requests.teachers.AddTeacherRequest;
import requests.teachers.DeleteTeacherRequest;
import requests.teachers.EditTeacherRequest;
import requests.teachers.GetTeacherByIdRequest;
import responses.subjects.AddSubjectResponse;
import responses.subjects.GetSubjectByIdResponse;
import responses.teachers.AddTeacherResponse;
import responses.teachers.GetTeacherByIdResponse;
import services.interfaces.ITeacherService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements ITeacherService {
    @Autowired
    ITeacherRepository teacherRepository;

    @Override
    public AddTeacherResponse add(AddTeacherRequest request) {
        Teacher teacher = new Teacher(null, request.getLastName(),request.getFirstName(),request.getMiddleName());

        var saved = teacherRepository.save(teacher);

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

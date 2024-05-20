package services.realizations;

import entities.Student;
import entities.StudentGroup;
import exceptions.service_exceptions.NotFoundService;
import exceptions.service_exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.IStudentGroupRepository;
import repositories.IStudentRepository;
import requests.students.*;
import responses.students.AddStudentResponse;
import responses.students.GetStudentByIdResponse;
import services.interfaces.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private IStudentGroupRepository studentGroupRepository;

    @Override
    public AddStudentResponse addStudent(AddStudentRequest request) throws NotFoundService {
        studentGroupRepository.findById(request.getGroupId()).orElseThrow(()->new NotFoundService("invalid group id"));
        Student student = new Student(null, request.getLastName(), request.getFirstName(),
                request.getMiddleName(), new StudentGroup(request.getGroupId(), null), request.getStatus());

        var saved = studentRepository.save(student);

        return new AddStudentResponse(saved.getId());
    }

    @Override
    public GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) throws NotFoundService {
        Optional<Student> student = studentRepository.findById(request.getId());

        return new GetStudentByIdResponse(student.orElseThrow(()->new NotFoundService("invalid student id")));
    }

    @Override
    public void deleteStudentById(DeleteStudentRequest request) throws NotFoundService {
        studentRepository.findById(request.getId()).orElseThrow(()->new NotFoundService("invalid student id"));
        studentRepository.deleteById(request.getId());
    }

    @Override
    public void editStudent(EditStudentRequest request) throws ServiceException {
        studentRepository.findById(request.getId()).orElseThrow(()->new ServiceException("invalid student id"));
        studentGroupRepository.findById(request.getGroupId()).orElseThrow(()->new ServiceException("invalid group id"));

        studentRepository.update(request.getLastName(), request.getFirstName(),
                    request.getMiddleName(), request.getStatus(), request.getGroupId(), request.getId());
    }

    @Override
    public List<GetStudentByIdResponse> getStudentsByGroup(GetStudentsByGroupRequest request) throws NotFoundService {
        studentGroupRepository.findById(request.getId()).orElseThrow(()->new NotFoundService("invalid group id"));
        List<Student> studentList = studentRepository.findAllStudentsByGroupId(request.getId());

        List<GetStudentByIdResponse> result = new ArrayList<>(studentList.size());
        for(Student st : studentList){
            result.add(new GetStudentByIdResponse(st));
        }
        return result;
    }
}

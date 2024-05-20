package services.realizations;

import entities.Student;
import entities.StudentGroup;
import exceptions.service_exceptions.NotFoundService;
import exceptions.service_exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import repositories.IStudentGroupRepository;
import repositories.IStudentRepository;
import requests.student_groups.AddStudentGroupRequest;
import requests.student_groups.DeleteStudentGroupRequest;
import requests.student_groups.EditStudentGroupRequest;
import requests.student_groups.GetStudentGroupByIdRequest;
import responses.student_groups.AddStudentGroupResponse;
import responses.student_groups.GetStudentGroupByIdResponse;
import responses.students.AddStudentResponse;
import responses.students.GetStudentByIdResponse;
import services.interfaces.IStudentGroupService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentGroupService implements IStudentGroupService {
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private IStudentGroupRepository studentGroupRepository;
    @Override
    public AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws NotFoundService {
        StudentGroup studentGroup = new StudentGroup(null, request.getName());

        var saved = studentGroupRepository.save(studentGroup);

        return new AddStudentGroupResponse(saved.getId(), saved.getName());
    }

    @Override
    public void deleteStudentGroup(DeleteStudentGroupRequest request) throws ServiceException {
        studentGroupRepository.findById(request.getId()).orElseThrow(()->new ServiceException("invalid studentGroup id"));
        if(!studentRepository.findAllStudentsByGroupId(request.getId()).isEmpty()){
            throw new ServiceException("can't delete group, where students exist");
        }

        studentGroupRepository.deleteById(request.getId());
    }

    @Override
    public void editStudentGroup(EditStudentGroupRequest request) throws NotFoundService {
        studentGroupRepository.findById(request.getId()).orElseThrow(()->new NotFoundService("invalid group id"));

        studentGroupRepository.update(request.getName(), request.getId());
    }

    @Override
    public GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws NotFoundService {
        studentGroupRepository.findById(request.getId()).orElseThrow(()->new NotFoundService("invalid group id"));

        Optional<StudentGroup> studentGroup = studentGroupRepository.findById(request.getId());

        return new GetStudentGroupByIdResponse(studentGroup.orElseThrow(()->new NotFoundService("invalid student id")));
    }
}

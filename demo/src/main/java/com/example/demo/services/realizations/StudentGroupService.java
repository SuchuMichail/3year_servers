package com.example.demo.services.realizations;

import com.example.demo.entities.StudentGroup;
import com.example.demo.exceptions.service_exceptions.NotFoundService;
import com.example.demo.exceptions.service_exceptions.ServiceException;
import com.example.demo.repositories.IStudentGroupRepository;
import com.example.demo.repositories.IStudentRepository;
import com.example.demo.requests.student_groups.AddStudentGroupRequest;
import com.example.demo.requests.student_groups.DeleteStudentGroupRequest;
import com.example.demo.requests.student_groups.EditStudentGroupRequest;
import com.example.demo.requests.student_groups.GetStudentGroupByIdRequest;
import com.example.demo.responses.student_groups.AddStudentGroupResponse;
import com.example.demo.responses.student_groups.GetStudentGroupByIdResponse;
import com.example.demo.services.interfaces.IStudentGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentGroupService implements IStudentGroupService {
    @Autowired
    private IStudentRepository studentRepository;
    @Autowired
    private IStudentGroupRepository studentGroupRepository;

    @Override
    public AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws NotFoundService {
        StudentGroup studentGroup = new StudentGroup(null, request.getName());

        StudentGroup saved = studentGroupRepository.save(studentGroup);

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

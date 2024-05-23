package com.example.demo.services.interfaces;

import com.example.demo.exceptions.service_exceptions.NotFoundService;
import com.example.demo.exceptions.service_exceptions.ServiceException;
import com.example.demo.requests.student_groups.AddStudentGroupRequest;
import com.example.demo.requests.student_groups.DeleteStudentGroupRequest;
import com.example.demo.requests.student_groups.EditStudentGroupRequest;
import com.example.demo.requests.student_groups.GetStudentGroupByIdRequest;
import com.example.demo.responses.student_groups.AddStudentGroupResponse;
import com.example.demo.responses.student_groups.GetStudentGroupByIdResponse;

public interface IStudentGroupService {
    AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws NotFoundService;
    void deleteStudentGroup(DeleteStudentGroupRequest request) throws ServiceException;
    void editStudentGroup(EditStudentGroupRequest request) throws NotFoundService;
    GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws NotFoundService;
}

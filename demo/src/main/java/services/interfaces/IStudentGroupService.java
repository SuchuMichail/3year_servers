package services.interfaces;

import exceptions.service_exceptions.NotFoundService;
import exceptions.service_exceptions.ServiceException;
import requests.student_groups.AddStudentGroupRequest;
import requests.student_groups.DeleteStudentGroupRequest;
import requests.student_groups.EditStudentGroupRequest;
import requests.student_groups.GetStudentGroupByIdRequest;
import responses.student_groups.AddStudentGroupResponse;
import responses.student_groups.GetStudentGroupByIdResponse;

import java.util.List;

public interface IStudentGroupService {
    AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws NotFoundService;
    void deleteStudentGroup(DeleteStudentGroupRequest request) throws ServiceException;
    void editStudentGroup(EditStudentGroupRequest request) throws NotFoundService;
    GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws NotFoundService;
}

package services;

import repositories.exceptions.StudentGroupRepositoryException;
import requests.student_groups.*;
import responses.student_groups.AddStudentGroupResponse;
import responses.student_groups.GetStudentGroupByIdResponse;
import services.exceptions.student_groups.*;

import java.util.List;

public interface IStudentGroupService {
    AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws AddStudentGroupServiceException;
    void deleteStudentGroup(DeleteStudentGroupRequest request) throws DeleteStudentGroupServiceException;
    void editStudentGroup(EditStudentGroupRequest request) throws EditStudentGroupServiceException;
    GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws GetStudentGroupByIdServiceException;
    List<GetStudentGroupByIdResponse> getStudentGroups(GetStudentGroupsRequest request) throws GetStudentGroupsServiceException;
}

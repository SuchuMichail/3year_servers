package services;

import entities.StudentGroup;
import repositories.DataBase;
import repositories.exceptions.StudentGroupRepositoryException;
import repositories.interfaces.IStudentGroupRepository;
import repositories.plugs.StudentGroupRepository;
import requests.student_groups.*;
import responses.student_groups.AddStudentGroupResponse;
import responses.student_groups.GetStudentGroupByIdResponse;
import services.exceptions.student_groups.*;

import java.util.ArrayList;
import java.util.List;

public class StudentGroupService implements IStudentGroupService{
    private IStudentGroupRepository repository;

    public StudentGroupService(DataBase base){
        repository = new StudentGroupRepository(base);
    }

    @Override
    public AddStudentGroupResponse addStudentGroup(AddStudentGroupRequest request) throws AddStudentGroupServiceException {
        try {
            StudentGroup studentGroup = new StudentGroup(null, request.getName());

            long id = repository.add(studentGroup);

            AddStudentGroupResponse response = new AddStudentGroupResponse(id);

            return response;
        }catch (StudentGroupRepositoryException e){
            throw new AddStudentGroupServiceException();
        }
    }

    @Override
    public void deleteStudentGroup(DeleteStudentGroupRequest request) throws DeleteStudentGroupServiceException {
        try{
            repository.deleteById(request.getId());
        }catch (StudentGroupRepositoryException e){
            throw new DeleteStudentGroupServiceException();
        }
    }

    @Override
    public void editStudentGroup(EditStudentGroupRequest request) throws EditStudentGroupServiceException {
        try {
            StudentGroup studentGroup = new StudentGroup(request.getId(), request.getName());

            repository.edit(studentGroup);
        }catch (StudentGroupRepositoryException e){
            throw new EditStudentGroupServiceException();
        }
    }

    @Override
    public GetStudentGroupByIdResponse getStudentGroupById(GetStudentGroupByIdRequest request) throws GetStudentGroupByIdServiceException {
        try {
            StudentGroup studentGroup = repository.getById(request.getId());

            return new GetStudentGroupByIdResponse(studentGroup.getId(), studentGroup.getName());
        }catch (StudentGroupRepositoryException e){
            throw new GetStudentGroupByIdServiceException();
        }
    }

    @Override
    public List<GetStudentGroupByIdResponse> getStudentGroups(GetStudentGroupsRequest request) throws GetStudentGroupsServiceException {
        try {
            List<GetStudentGroupByIdResponse> responses = new ArrayList<>();

            List<StudentGroup> groups = repository.getAll();

            for (StudentGroup iter : groups) {
                responses.add(new GetStudentGroupByIdResponse(iter.getId(), iter.getName()));
            }

            return responses;
        }catch (StudentGroupRepositoryException e){
            throw new GetStudentGroupsServiceException();
        }
    }
}

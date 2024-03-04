package services;

import entities.Student;
import repositories.DataBase;
import repositories.exceptions.StudentRepositoryException;
import repositories.interfaces.IStudentRepository;
import repositories.plugs.StudentRepository;
import requests.students.*;
import responses.students.AddStudentResponse;
import responses.students.GetStudentByIdResponse;
import services.exceptions.students.*;

import java.util.ArrayList;
import java.util.List;

public class StudentService implements IStudentService{
    private IStudentRepository repository;

    public StudentService(DataBase base) {
        repository = new StudentRepository(base);
    }

    @Override
    public AddStudentResponse addStudent(AddStudentRequest request) throws AddStudentServiceException {
        try {
            Student student = new Student(null, request.getLastName(), request.getFirstName(),
                    request.getMiddleName(), request.getGroupId(), request.getStatus());

            long id = repository.add(student);

            return new AddStudentResponse(id);
        }catch(StudentRepositoryException e){
            throw new AddStudentServiceException(e);
        }
    }

    @Override
    public GetStudentByIdResponse getStudentById(GetStudentByIdRequest request) throws GetStudentByIdServiceException {
        try {
            Student student = repository.getById(request.getId());

            return new GetStudentByIdResponse(student.getId(), student.getLastName(), student.getFirstName(),
                    student.getMiddleName(), student.getGroupId(), student.getStatus());
        }catch (StudentRepositoryException e){
            throw new GetStudentByIdServiceException();
        }
    }

    @Override
    public void deleteStudent(DeleteStudentRequest request) throws DeleteStudentServiceException {
        try{
            repository.deleteById(request.getId());
        }catch (StudentRepositoryException e){
            throw new DeleteStudentServiceException();
        }
    }

    @Override
    public void editStudent(EditStudentRequest request) throws EditStudentServiceException {
        try {
            Student student = new Student(request.getId(), request.getLastName(), request.getFirstName(),
                    request.getMiddleName(), request.getGroupId(), request.getStatus());

            repository.edit(student);
        }catch (StudentRepositoryException e){
            throw new EditStudentServiceException();
        }
    }

    @Override
    public List<GetStudentByIdResponse> getStudentsByGroup(GetStudentsByGroupRequest request) throws GetStudentsByGroupServiceException {
        try {
            List<GetStudentByIdResponse> responses = new ArrayList<>();

            List<Student> students = repository.getAll();

            long groupId = request.getId();

            for (Student st : students) {
                if (st.getGroupId() == groupId) {
                    responses.add(new GetStudentByIdResponse(st.getId(), st.getLastName(), st.getFirstName(),
                            st.getMiddleName(), st.getGroupId(), st.getStatus()));
                }
            }

            return responses;
        }catch (StudentRepositoryException e){
            throw new GetStudentsByGroupServiceException();
        }
    }
}

package repositories.interfaces;

import entities.StudentGroup;
import repositories.exceptions.StudentGroupRepositoryException;

import java.util.List;

public interface IStudentGroupRepository {
    long add(StudentGroup studentGroup) throws StudentGroupRepositoryException;
    void edit(StudentGroup studentGroup) throws StudentGroupRepositoryException;
    void deleteById(long id) throws StudentGroupRepositoryException;
    StudentGroup getById(long id) throws StudentGroupRepositoryException;
    List<StudentGroup> getAll() throws StudentGroupRepositoryException;
}

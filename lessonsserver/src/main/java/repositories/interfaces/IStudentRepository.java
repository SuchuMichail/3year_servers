package repositories.interfaces;

import entities.Student;
import repositories.exceptions.StudentRepositoryException;

import java.util.List;

public interface IStudentRepository {
    long add(Student student) throws StudentRepositoryException;
    void edit(Student student) throws StudentRepositoryException;
    void deleteById(long id) throws StudentRepositoryException;
    Student getById(long id) throws StudentRepositoryException;
    List<Student> getAll() throws StudentRepositoryException;
}

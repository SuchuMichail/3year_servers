package repositories.interfaces;

import entities.Teacher;
import repositories.exceptions.TeacherRepositoryException;

import java.util.List;

public interface ITeacherRepository {
    long add(Teacher teacher) throws TeacherRepositoryException;
    void edit(Teacher teacher) throws TeacherRepositoryException;
    void deleteById(long id) throws TeacherRepositoryException;
    Teacher getById(long id) throws TeacherRepositoryException;
    List<Teacher> getAll() throws TeacherRepositoryException;
}

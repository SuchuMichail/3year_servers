package repositories.interfaces;

import entities.Subject;
import repositories.exceptions.SubjectRepositoryException;

import java.util.List;

public interface ISubjectRepository {
    long add(Subject subject) throws SubjectRepositoryException;
    void edit(Subject subject) throws SubjectRepositoryException;
    void deleteById(long id) throws SubjectRepositoryException;
    Subject getById(long id) throws SubjectRepositoryException;
    List<Subject> getAll() throws SubjectRepositoryException;
}

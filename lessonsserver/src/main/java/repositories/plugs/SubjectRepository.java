package repositories.plugs;

import entities.Lesson;
import entities.Student;
import entities.Subject;
import repositories.DataBase;
import repositories.exceptions.SubjectRepositoryException;
import repositories.interfaces.ISubjectRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubjectRepository implements ISubjectRepository {
    private final Map<Long, Subject> subjectMap;
    private long id;

    public SubjectRepository(DataBase base){
        subjectMap=base.getSubjectMap();
    }

    @Override
    public long add(Subject subject) {
        id++;

        subjectMap.put(id, new Subject(id, subject.getName()));

        return id;
    }

    @Override
    public void edit(Subject subject) throws SubjectRepositoryException {
        subjectMap.put(subject.getId(), subject);
    }

    @Override
    public void deleteById(long id) throws SubjectRepositoryException {
        subjectMap.remove(id);
    }

    @Override
    public Subject getById(long id) throws SubjectRepositoryException {
        return subjectMap.get(id);
    }

    @Override
    public List<Subject> getAll() throws SubjectRepositoryException {
        List<Subject> list = new ArrayList<>();
        for(Map.Entry<Long,Subject> entry : subjectMap.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}

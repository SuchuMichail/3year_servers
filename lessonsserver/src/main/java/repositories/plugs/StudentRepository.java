package repositories.plugs;

import entities.Student;
import repositories.DataBase;
import repositories.exceptions.StudentRepositoryException;
import repositories.interfaces.IStudentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentRepository implements IStudentRepository {
    private final Map<Long,Student> studentMap;
    private long id;

    public StudentRepository(DataBase base){
        studentMap=base.getStudentMap();
    }

    @Override
    public long add(Student student) throws StudentRepositoryException {
        id++;

        studentMap.put(id,new Student(id,student.getLastName(), student.getFirstName(),
                student.getMiddleName(), student.getGroupId(), student.getStatus()));

        return id;
    }

    @Override
    public void edit(Student student) throws StudentRepositoryException {
        studentMap.put(student.getId(),student);
    }

    @Override
    public void deleteById(long id) throws StudentRepositoryException {
        studentMap.remove(id);
    }

    @Override
    public Student getById(long id) throws StudentRepositoryException {
        return studentMap.get(id);
    }

    @Override
    public List<Student> getAll() throws StudentRepositoryException {
        List<Student> list = new ArrayList<>();
        for(Map.Entry<Long,Student> entry : studentMap.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}

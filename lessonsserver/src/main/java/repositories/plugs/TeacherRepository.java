package repositories.plugs;

import entities.Student;
import entities.Subject;
import entities.Teacher;
import repositories.DataBase;
import repositories.exceptions.TeacherRepositoryException;
import repositories.interfaces.ITeacherRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TeacherRepository implements ITeacherRepository {
    private final Map<Long, Teacher> teacherMap;
    private long id;

    public TeacherRepository(DataBase base){
        teacherMap=base.getTeacherMap();
    }

    @Override
    public long add(Teacher teacher) throws TeacherRepositoryException {
        id++;

        teacherMap.put(id, new Teacher(id,teacher.getLastName(),teacher.getFirstName(),teacher.getMiddleName()));

        return id;
    }

    @Override
    public void edit(Teacher teacher) throws TeacherRepositoryException {
        teacherMap.put(teacher.getId(),teacher);
    }

    @Override
    public void deleteById(long id) throws TeacherRepositoryException {
        teacherMap.remove(id);
    }

    @Override
    public Teacher getById(long id) throws TeacherRepositoryException {
        return teacherMap.get(id);
    }

    @Override
    public List<Teacher> getAll() throws TeacherRepositoryException {
        List<Teacher> list = new ArrayList<>();
        for(Map.Entry<Long,Teacher> entry : teacherMap.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}

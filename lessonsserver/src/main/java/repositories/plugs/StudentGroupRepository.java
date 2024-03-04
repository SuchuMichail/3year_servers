package repositories.plugs;

import entities.Student;
import entities.StudentGroup;
import repositories.DataBase;
import repositories.exceptions.StudentGroupRepositoryException;
import repositories.interfaces.IStudentGroupRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StudentGroupRepository implements IStudentGroupRepository {
    private final Map<Long,StudentGroup> groupMap;
    private long id;

    public StudentGroupRepository(DataBase base){
        groupMap=base.getStudenGrouptMap();
    }

    @Override
    public long add(StudentGroup studentGroup) throws StudentGroupRepositoryException {
        id++;

        groupMap.put(id,new StudentGroup(id,studentGroup.getName()));

        return id;
    }

    @Override
    public void edit(StudentGroup studentGroup) throws StudentGroupRepositoryException {
        groupMap.put(studentGroup.getId(),studentGroup);
    }

    @Override
    public void deleteById(long id) throws StudentGroupRepositoryException {
        groupMap.remove(id);
    }

    @Override
    public StudentGroup getById(long id) throws StudentGroupRepositoryException {
        return groupMap.get(id);
    }

    @Override
    public List<StudentGroup> getAll() throws StudentGroupRepositoryException {
        List<StudentGroup> list = new ArrayList<>();
        for(Map.Entry<Long,StudentGroup> entry : groupMap.entrySet()){
            list.add(entry.getValue());
        }
        return list;
    }
}

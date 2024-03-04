package repositories.plugs;

import entities.Attendance;
import entities.Lesson;
import entities.Student;
import repositories.DataBase;
import repositories.exceptions.LessonRepositoryException;
import repositories.interfaces.ILessonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LessonRepository implements ILessonRepository {
    private final Map<Long, Lesson> lessonMap;
    private long id;

    public LessonRepository(DataBase base){
        lessonMap=base.getLessonMap();
    }

    @Override
    public long add(Lesson lesson) throws LessonRepositoryException {
        id++;

        lessonMap.put(id, new Lesson(id, lesson.getStartDate(),
                lesson.getEndDate(), lesson.getGroupId(), lesson.getTeacherId()));

        return id;
    }

    @Override
    public void edit(Lesson lesson) throws LessonRepositoryException{
        lessonMap.put(lesson.getId(), lesson);
    }

    @Override
    public void deleteById(long id) throws LessonRepositoryException{
        lessonMap.remove(id);
    }

    @Override
    public Lesson getBuId(long id) throws LessonRepositoryException{
        return lessonMap.get(id);
    }

    @Override
    public List<Lesson> getAllLessonsByTeacherIdAndSegmentOfDates(long idTeacher, String startDate, String endDate) throws LessonRepositoryException{
        List<Lesson> list = new ArrayList<>();
        for(Map.Entry<Long,Lesson> entry : lessonMap.entrySet()){
            if(entry.getValue().getTeacherId() == idTeacher &&
                    entry.getValue().getStartDate().equals(startDate) &&
                    entry.getValue().getEndDate().equals(endDate)) {
                list.add(entry.getValue());
            }
        }
        return list;
    }

    @Override
    public List<Lesson> getAllLessonsByGroupIdAndSegmentOfDates(long idGroup, String startDate, String endDate) throws LessonRepositoryException{
        List<Lesson> list = new ArrayList<>();
        for(Map.Entry<Long,Lesson> entry : lessonMap.entrySet()){
            if(entry.getValue().getTeacherId() == idGroup &&
                    entry.getValue().getStartDate().equals(startDate) &&
                    entry.getValue().getEndDate().equals(endDate)) {
                list.add(entry.getValue());
            }
        }
        return list;
    }

    @Override
    public void deleteAllByTeacherId(long idTeacher) throws LessonRepositoryException{
        for (Map.Entry<Long,Lesson> entry : lessonMap.entrySet()){
            if(entry.getValue().getTeacherId() == idTeacher){
                lessonMap.remove(entry.getKey());
            }
        }
    }

    @Override
    public void deleteAllByGroupId(long idGroup) throws LessonRepositoryException{
        for (Map.Entry<Long,Lesson> entry : lessonMap.entrySet()){
            if(entry.getValue().getGroupId() == idGroup){
                lessonMap.remove(entry.getKey());
            }
        }
    }
}

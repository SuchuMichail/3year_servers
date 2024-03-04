package repositories.interfaces;

import entities.Lesson;
import repositories.exceptions.LessonRepositoryException;

import java.util.List;

public interface ILessonRepository {
    long add(Lesson lesson) throws LessonRepositoryException;
    void edit(Lesson lesson) throws LessonRepositoryException;
    void deleteById(long id) throws LessonRepositoryException;
    Lesson getBuId(long id) throws  LessonRepositoryException;

    List<Lesson> getAllLessonsByTeacherIdAndSegmentOfDates(long idTeacher, String startDate, String endDate) throws LessonRepositoryException;

    List<Lesson> getAllLessonsByGroupIdAndSegmentOfDates(long idGroup, String startDate, String endDate) throws LessonRepositoryException;

    void deleteAllByTeacherId(long idTeacher) throws LessonRepositoryException;
    void deleteAllByGroupId(long idGroup) throws LessonRepositoryException;
}

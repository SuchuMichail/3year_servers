package repositories.interfaces;

import entities.Attendance;
import repositories.exceptions.AttendanceRepositoryException;

public interface IAttendanceRepository {
    void addByLessonId(Attendance attendance) throws AttendanceRepositoryException;
    void deleteByLessonId(long idLesson) throws AttendanceRepositoryException;
}

package repositories.plugs;

import entities.Attendance;
import entities.StudentGroup;
import repositories.DataBase;
import repositories.exceptions.AttendanceRepositoryException;
import repositories.interfaces.IAttendanceRepository;

import java.util.Map;

public class AttendanceRepository implements IAttendanceRepository {
    private final Map<Long, Attendance> attendanceMap;

    public AttendanceRepository(DataBase base){
        attendanceMap=base.getAttendanceMap();
    }

    @Override
    public void addByLessonId(Attendance attendance) throws AttendanceRepositoryException {
        attendanceMap.put(attendance.getLesson().getId(), attendance);
    }

    @Override
    public void deleteByLessonId(long idLesson) throws AttendanceRepositoryException {
        attendanceMap.remove(idLesson);
    }
}

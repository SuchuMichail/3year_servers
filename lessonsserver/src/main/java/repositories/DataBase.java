package repositories;

import entities.*;

import java.util.HashMap;
import java.util.Map;

public class DataBase {
    private final Map<Long,Student> studentMap = new HashMap<>();
    private final Map<Long, Lesson> lessonMap = new HashMap<>();
    private final Map<Long, Teacher> teacherMap = new HashMap<>();
    private final Map<Long, StudentGroup> studenGrouptMap = new HashMap<>();
    private final Map<Long, Subject> subjectMap = new HashMap<>();
    private final Map<Long,Attendance> attendanceMap = new HashMap<>();

    public DataBase(){}

    public Map<Long, Student> getStudentMap() {
        return studentMap;
    }

    public Map<Long, Lesson> getLessonMap() {
        return lessonMap;
    }

    public Map<Long, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public Map<Long, StudentGroup> getStudenGrouptMap() {
        return studenGrouptMap;
    }

    public Map<Long, Subject> getSubjectMap() {
        return subjectMap;
    }

    public Map<Long, Attendance> getAttendanceMap() {
        return attendanceMap;
    }
}

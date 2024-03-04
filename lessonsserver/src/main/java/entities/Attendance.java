package entities;

import java.util.List;
import java.util.Objects;

public class Attendance {
    private Lesson lesson;
    private List<Student> students;

    public Attendance(Lesson lesson, List<Student> students) {
        this.lesson = lesson;
        this.students = students;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public List<Student> getStudents() {
        return students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendance that = (Attendance) o;
        return Objects.equals(lesson, that.lesson) && Objects.equals(students, that.students);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lesson, students);
    }
}

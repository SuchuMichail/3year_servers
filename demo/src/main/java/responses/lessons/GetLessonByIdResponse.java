package responses.lessons;

import entities.Lesson;
import entities.LessonAttendance;
import lombok.Data;
import responses.student_groups.GetStudentGroupByIdResponse;
import responses.students.GetStudentByIdResponse;
import responses.subjects.GetSubjectByIdResponse;
import responses.teachers.GetTeacherByIdResponse;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

@Data
public class GetLessonByIdResponse {
    private long id;
    private GetSubjectByIdResponse subject;
    private String startDate;
    private String endDate;
    private final GetTeacherByIdResponse teacher;
    private final GetStudentGroupByIdResponse group;
    private List<GetStudentByIdResponse> students = new ArrayList<>();

    @ConstructorProperties({"id", "subject", "startDate", "endDate", "teacher", "group", "list"})
    public GetLessonByIdResponse(long id,
                                 GetSubjectByIdResponse subject,
                                 String startDate,
                                 String endDate,
                                 GetTeacherByIdResponse teacher,
                                 GetStudentGroupByIdResponse group,
                                 List<GetStudentByIdResponse> list) {
        this.id = id;
        this.subject = subject;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacher = teacher;
        this.group = group;
        if (list == null) {
            students = null;
        } else {
            students.addAll(list);
        }
    }

    public GetLessonByIdResponse(Lesson lesson, LessonAttendance lessonAttendance) {
        this(
                lesson.getId(),
                new GetSubjectByIdResponse(lesson.getSubject()),
                lesson.getStartDate(),
                lesson.getEndDate(),
                new GetTeacherByIdResponse(lesson.getTeacher()),
                new GetStudentGroupByIdResponse(lesson.getGroup()),
                lessonAttendance == null ? null : lessonAttendance.getStudents().stream().map(GetStudentByIdResponse::new).toList()
        );
    }
}

package com.example.demo.responses.lessons;

import com.example.demo.entities.Lesson;
import com.example.demo.entities.LessonAttendance;
import com.example.demo.responses.subjects.GetSubjectByIdResponse;
import lombok.Data;
import com.example.demo.responses.student_groups.GetStudentGroupByIdResponse;
import com.example.demo.responses.students.GetStudentByIdResponse;
import com.example.demo.responses.teachers.GetTeacherByIdResponse;

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

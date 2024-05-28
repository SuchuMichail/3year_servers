package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "lesson_attendance")
public class LessonAttendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_lesson", referencedColumnName = "id", unique = true)
    private Lesson lesson;

    @ManyToMany
    @JoinTable(name = "lesson_attendance_record",
            joinColumns = @JoinColumn(name = "id_lesson_attendance"),
            inverseJoinColumns = @JoinColumn(name = "id_student"))
    private List<Student> students = new ArrayList<>();

    public LessonAttendance(){};

    public LessonAttendance(Long id, Lesson lesson, List<Student> students) {
        this.id= id;
        this.lesson = lesson;
        this.students.addAll(students);
    }
}

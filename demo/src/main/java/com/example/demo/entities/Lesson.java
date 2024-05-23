package com.example.demo.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "start_date", nullable = false)
    private String startDate;
    @Column(name = "end_date", nullable = false)
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "id_subject", referencedColumnName = "id")
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "id_group", referencedColumnName = "id")
    private StudentGroup group;

    @ManyToOne
    @JoinColumn(name = "id_teacher", referencedColumnName = "id")
    private Teacher teacher;

    public Lesson(Long id, Subject subject, String startDate, String endDate, Teacher teacher, StudentGroup group) {
        this.id = id;
        this.subject = subject;
        this.startDate = startDate;
        this.endDate = endDate;
        this.group = group;
        this.teacher = teacher;
    }

    public Lesson(Lesson lesson) {
        this(lesson.getId(), lesson.getSubject(), lesson.getStartDate(), lesson.getEndDate(), lesson.getTeacher(), lesson.getGroup());
    }
}

package com.example.demo.repositories;

import com.example.demo.entities.LessonAttendance;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ILessonAttendanceRepository extends JpaRepository<LessonAttendance,Long> {
    @Transactional
    @Query("SELECT la FROM LessonAttendance AS la WHERE la.lesson.id = :lessonId")
    LessonAttendance findAttendanceByLessonId(@Param(value = "lessonId") Long lessonId);

    @Transactional
    @Modifying
    @Query("DELETE FROM LessonAttendance AS la WHERE la.lesson.id = :lessonId")
    void deleteAttendanceByLessonId(@Param(value = "lessonId") Long lessonId);
}

package com.example.demo.repositories;


import com.example.demo.entities.Lesson;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface ILessonRepository extends JpaRepository<Lesson,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Lesson AS ls "+
            "SET ls.subject.id = :subjectId, " +
            "ls.startDate = :startDate, "+
            "ls.endDate = :endDate, "+
            "ls.group.id = :groupId, "+
            "ls.teacher.id = :teacherId "+
            "WHERE ls.id = :id")
    void update(@Param(value = "subjectId") Long subjectId,
                @Param(value = "startDate") String startDate,
                @Param(value = "endDate") String endDate,
                @Param(value = "groupId") Long groupId,
                @Param(value = "teacherId") Long teacherId,
                @Param(value = "id") Long id);


    @Transactional
    @Query("SELECT ls FROM Lesson AS ls WHERE ls.group.id = :groupId AND startDate >= :startDate AND endDate <= :endDate")
    List<Lesson> findAllLessonsByGroupId(@Param(value = "groupId") Long groupId,
                                              @Param(value = "startDate") String startDate,
                                              @Param(value = "endDate") String endDate);
    @Transactional
    @Query("SELECT ls FROM Lesson AS ls WHERE ls.teacher.id = :teacherId AND startDate >= :startDate AND endDate <= :endDate")
    List<Lesson> findAllLessonsByTeacherId(@Param(value = "teacherId") Long teacherId,
                                           @Param(value = "startDate") String startDate,
                                           @Param(value = "endDate") String endDate);
}
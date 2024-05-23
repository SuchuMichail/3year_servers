package com.example.demo.repositories;

import com.example.demo.entities.StudentGroup;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentGroupRepository extends JpaRepository<StudentGroup,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE StudentGroup AS stg "+
            "SET stg.name = :name "+
            "WHERE stg.id = :id")
    void update(@Param(value = "name") String name,
                @Param(value = "id") Long id);
}

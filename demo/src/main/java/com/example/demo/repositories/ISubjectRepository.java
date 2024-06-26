package com.example.demo.repositories;

import com.example.demo.entities.Subject;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Subject AS sub "+
            "SET sub.name = :name "+
            "WHERE sub.id = :id")
    void update(@Param(value = "name") String name,
                @Param(value = "id") Long id);
}

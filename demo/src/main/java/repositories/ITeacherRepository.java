package repositories;

import entities.Teacher;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepository extends JpaRepository<Teacher,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Teacher AS t "+
            "SET t.lastName = :lastName, "+
            "t.firstName = :firstName, "+
            "t.middleName = :middleName "+
            "WHERE t.id = :id")
    void update(@Param(value = "lastName") String lastName,
                @Param(value = "firstName") String firstName,
                @Param(value = "middleName") String middleName,
                @Param(value = "id") Long id);
}

package repositories;

import entities.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository extends JpaRepository<Student,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE Student AS st "+
            "SET st.lastName = :lastName, "+
                "st.firstName = :firstName, "+
                "st.middleName = :middleName, "+
                "st.status = :status, "+
                "st.groupId = :groupId "+
            "WHERE st.id = :id")
    void update(@Param(value = "lastName") String lastName,
                @Param(value = "firstName") String firstName,
                @Param(value = "middleName") String middleName,
                @Param(value = "status") String status,
                @Param(value = "groupId") Long groupId,
                @Param(value = "id") Long id);

    @Transactional
    @Modifying
    @Query("SELECT st FROM Student AS st "+
            "WHERE st.groupId = :groupId")
    List<Student> getStudentsByGroup(@Param(value = "groupId") Long groupId);
}

package responses.students;

import entities.Student;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class AddStudentResponse {
    private long id;

    @ConstructorProperties({"id"})
    public AddStudentResponse(long id) {
        this.id = id;
    }

    public AddStudentResponse(Student student) {
        this(student.getId());
    }
}

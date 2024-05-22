package responses.student_groups;

import entities.StudentGroup;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class GetStudentGroupByIdResponse {
    private long id;
    private String name;

    @ConstructorProperties({"id", "name"})
    public GetStudentGroupByIdResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GetStudentGroupByIdResponse(StudentGroup group) {
        this(group.getId(), group.getName());
    }
}

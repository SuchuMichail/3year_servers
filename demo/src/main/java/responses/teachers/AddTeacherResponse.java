package responses.teachers;

import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class AddTeacherResponse {
    private long id;

    @ConstructorProperties({"id"})
    public AddTeacherResponse(long id) {
        this.id = id;
    }
}

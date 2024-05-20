package requests.teachers;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class DeleteTeacherRequest {
    @NotNull
    private long id;

    @ConstructorProperties({"id"})
    public DeleteTeacherRequest(long id) {
        this.id = id;
    }
}

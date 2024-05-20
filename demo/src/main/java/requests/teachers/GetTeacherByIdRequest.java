package requests.teachers;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class GetTeacherByIdRequest {
    @NotNull
    private long id;

    @ConstructorProperties({"id"})
    public GetTeacherByIdRequest(long id) {
        this.id = id;
    }
}

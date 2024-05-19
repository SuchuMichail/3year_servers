package requests.students;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class DeleteStudentRequest {
    @NotNull
    //@Pattern(regexp = "[0-9]*")
    private long id;

    @ConstructorProperties({"id"})
    public DeleteStudentRequest(long id) {
        this.id = id;
    }
}

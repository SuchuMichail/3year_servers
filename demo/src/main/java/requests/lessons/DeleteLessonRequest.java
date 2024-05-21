package requests.lessons;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class DeleteLessonRequest {
    @NotNull
    private Long id;

    @ConstructorProperties({"id"})
    public DeleteLessonRequest(Long id) {
        this.id = id;
    }
}

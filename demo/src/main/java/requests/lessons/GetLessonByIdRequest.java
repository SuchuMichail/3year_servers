package requests.lessons;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class GetLessonByIdRequest {
    @NotNull
    private Long id;

    @ConstructorProperties({"id"})
    public GetLessonByIdRequest(Long id) {
        this.id = id;
    }
}

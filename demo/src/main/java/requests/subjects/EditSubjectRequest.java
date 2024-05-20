package requests.subjects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.beans.ConstructorProperties;

@Data
public class EditSubjectRequest {
    @NotNull
    private long id;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 100)
    private String name;

    @ConstructorProperties({"id", "name"})
    public EditSubjectRequest(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

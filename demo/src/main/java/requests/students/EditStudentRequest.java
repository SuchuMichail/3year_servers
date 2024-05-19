package requests.students;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.beans.ConstructorProperties;

@Data
public class EditStudentRequest {
    @NotNull
    private long id;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 100)
    private String lastName;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 100)
    private String firstName;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 100)
    private String middleName;
    @NotNull
    private String status;
    @NotNull
    private long groupId;
    @ConstructorProperties({"id","lastName","firstName","middleName","status","groupId"})
    public EditStudentRequest(long id, String lastName, String firstName, String middleName, String status, long groupId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.groupId = groupId;
        this.status = status;
    }
}

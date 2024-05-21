package requests.lessons;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.beans.ConstructorProperties;

@Data
public class GetLessonsByGroupRequest {
    @NotNull
    @NotBlank
    @Length(min = 1, max = 100)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String startDate;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 100)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String endDate;
    @NotNull
    private Long groupId;

    @ConstructorProperties({"startDate", "endDate", "groupId"})
    public GetLessonsByGroupRequest(String startDate, String endDate, Long groupId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupId = groupId;
    }
}

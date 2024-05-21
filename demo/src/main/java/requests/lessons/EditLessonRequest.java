package requests.lessons;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

@Data
public class EditLessonRequest {
    @NotNull
    private Long id;
    @NotNull
    private Long subjectId;
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
    private Long teacherId;
    @NotNull
    private Long groupId;
    private List<Long> attendanceList;

    @ConstructorProperties({"id", "subjectId", "startDate", "endDate", "teacherId", "groupId", "attendanceList"})
    public EditLessonRequest(Long id, Long subjectId, String startDate, String endDate, Long teacherId, Long groupId, List<Long> attendanceList) {
        this.id = id;
        this.subjectId = subjectId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
        this.groupId = groupId;
        if (attendanceList == null) this.attendanceList = null;
        else {
            this.attendanceList = new ArrayList<>(attendanceList.size());
            this.attendanceList.addAll(attendanceList);
        }
    }
}

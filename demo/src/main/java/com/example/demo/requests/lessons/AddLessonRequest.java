package com.example.demo.requests.lessons;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.List;

@Data
public class AddLessonRequest {
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

    @JsonCreator
    public AddLessonRequest(@JsonProperty("subjectId") Long subjectId,
                            @JsonProperty("startDate") String startDate,
                            @JsonProperty("endDate") String endDate,
                            @JsonProperty("teacherId") Long teacherId,
                            @JsonProperty("groupId") Long groupId,
                            @JsonProperty("attendanceList") List<Long> attendanceList) {
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

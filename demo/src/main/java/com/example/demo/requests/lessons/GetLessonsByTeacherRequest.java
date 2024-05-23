package com.example.demo.requests.lessons;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.beans.ConstructorProperties;

@Data
public class GetLessonsByTeacherRequest {
    @NotNull
    @NotBlank
    @Length(min = 1, max = 100)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private String startDate;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 100)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String endDate;
    @NotNull
    private final Long teacherId;

    @ConstructorProperties({"startDate", "endDate", "teacherId"})
    public GetLessonsByTeacherRequest(String startDate, String endDate, Long teacherId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
    }
}

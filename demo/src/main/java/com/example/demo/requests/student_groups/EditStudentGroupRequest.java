package com.example.demo.requests.student_groups;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.beans.ConstructorProperties;

@Data
public class EditStudentGroupRequest {
    @NotNull
    private long id;
    @NotNull
    @NotBlank
    @Length(min = 1, max = 100)
    private final String name;

    @ConstructorProperties({"id", "name"})
    public EditStudentGroupRequest(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

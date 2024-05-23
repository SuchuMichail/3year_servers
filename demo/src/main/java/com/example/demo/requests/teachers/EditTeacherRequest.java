package com.example.demo.requests.teachers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.beans.ConstructorProperties;

@Data
public class EditTeacherRequest {
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

    @ConstructorProperties({"id", "lastName", "firstName", "middleName"})
    public EditTeacherRequest(long id, String lastName, String firstName, String middleName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
}

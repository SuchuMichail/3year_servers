package com.example.demo.requests.teachers;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.beans.ConstructorProperties;

@Data
public class AddTeacherRequest {
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

    @ConstructorProperties({"lastName", "firstName", "middleName"})
    public AddTeacherRequest(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }
}

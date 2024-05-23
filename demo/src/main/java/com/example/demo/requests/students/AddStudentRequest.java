package com.example.demo.requests.students;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.beans.ConstructorProperties;

@Data
public class AddStudentRequest {
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

    @ConstructorProperties({"lastName", "firstName", "middleName", "status", "groupId"})
    public AddStudentRequest(String lastName, String firstName, String middleName, String status, long groupId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.groupId = groupId;
        this.status = status;
    }
}

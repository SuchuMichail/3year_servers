package com.example.demo.requests.student_groups;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class DeleteStudentGroupRequest {
    @NotNull
    private long id;

    @ConstructorProperties({"id"})
    public DeleteStudentGroupRequest(long id) {
        this.id = id;
    }
}

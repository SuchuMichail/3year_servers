package com.example.demo.requests.student_groups;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class GetStudentGroupByIdRequest {
    @NotNull
    private long id;

    @ConstructorProperties({"id"})
    public GetStudentGroupByIdRequest(long id) {
        this.id = id;
    }
}

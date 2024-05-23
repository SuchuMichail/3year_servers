package com.example.demo.requests.students;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class GetStudentByIdRequest {
    @NotNull
    private long id;

    @ConstructorProperties({"id"})
    public GetStudentByIdRequest(long id) {
        this.id = id;
    }
}

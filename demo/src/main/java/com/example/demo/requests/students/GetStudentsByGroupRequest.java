package com.example.demo.requests.students;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class GetStudentsByGroupRequest {
    @NotNull
    private long id;

    @ConstructorProperties({"id"})
    public GetStudentsByGroupRequest(long id) {
        this.id = id;
    }
}

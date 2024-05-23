package com.example.demo.requests.subjects;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class GetSubjectByIdRequest {
    @NotNull
    private long id;

    @ConstructorProperties({"id"})
    public GetSubjectByIdRequest(long id) {
        this.id = id;
    }
}

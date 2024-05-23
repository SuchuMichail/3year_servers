package com.example.demo.responses.subjects;

import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class AddSubjectResponse {
    private long id;

    @ConstructorProperties({"id"})
    public AddSubjectResponse(long id) {
        this.id = id;
    }
}

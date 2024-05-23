package com.example.demo.responses.student_groups;

import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class AddStudentGroupResponse {
    private long id;
    private String name;

    @ConstructorProperties({"id", "name"})
    public AddStudentGroupResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

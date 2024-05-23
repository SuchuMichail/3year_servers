package com.example.demo.responses.teachers;

import com.example.demo.entities.Teacher;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class GetTeacherByIdResponse {
    private long id;
    private String lastName;
    private String firstName;
    private String middleName;

    @ConstructorProperties({"id", "lastName", "firstName", "middleName"})
    public GetTeacherByIdResponse(long id, String lastName, String firstName, String middleName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
    }

    public GetTeacherByIdResponse(Teacher teacher) {
        this(teacher.getId(), teacher.getLastName(), teacher.getFirstName(), teacher.getMiddleName());
    }
}

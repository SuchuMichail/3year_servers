package com.example.demo.responses.students;

import com.example.demo.entities.Student;
import lombok.Data;
import com.example.demo.responses.student_groups.GetStudentGroupByIdResponse;

import java.beans.ConstructorProperties;

@Data
public class GetStudentByIdResponse {
    private long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private String status;
    private GetStudentGroupByIdResponse getStudentsByGroupResponse;

    @ConstructorProperties({"id", "lastName", "firstName", "middleName", "status", "group"})
    public GetStudentByIdResponse(long id, String lastName, String firstName, String middleName, String status, GetStudentGroupByIdResponse getStudentsByGroupResponse) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.status = status;
        this.getStudentsByGroupResponse = getStudentsByGroupResponse;
    }

    public GetStudentByIdResponse(Student student) {
        this(student.getId(), student.getLastName(), student.getFirstName(), student.getMiddleName(), student.getStatus(), new GetStudentGroupByIdResponse(student.getGroup()));
    }
}

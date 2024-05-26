package com.example.demo.requests.student_groups;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class GetStudentGroupByIdRequest {
    @NotNull
    //@Pattern(regexp = "[0-9]*")
    private long id;

    @ConstructorProperties({"id"})
    public GetStudentGroupByIdRequest(long id) {
        this.id = id;
    }
}

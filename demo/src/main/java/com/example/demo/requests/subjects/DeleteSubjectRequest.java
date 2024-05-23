package com.example.demo.requests.subjects;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class DeleteSubjectRequest {
    @NotNull
    //@Pattern(regexp = "[0-9]*")
    private long id;

    @ConstructorProperties({"id"})
    public DeleteSubjectRequest(long id) {
        this.id = id;
    }
}

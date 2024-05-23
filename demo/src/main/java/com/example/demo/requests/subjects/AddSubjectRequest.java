package com.example.demo.requests.subjects;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.beans.ConstructorProperties;

@Data
public class AddSubjectRequest {
    @NotNull
    @NotBlank
    @Length(min = 1, max = 100)
    private String name;

    @ConstructorProperties({"name"})
    public AddSubjectRequest(String name) {
        this.name = name;
    }
}

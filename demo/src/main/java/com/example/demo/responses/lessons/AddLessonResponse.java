package com.example.demo.responses.lessons;

import com.example.demo.entities.Lesson;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class AddLessonResponse {
    private long id;

    @ConstructorProperties({"id"})
    public AddLessonResponse(long id) {
        this.id = id;
    }

    public AddLessonResponse(Lesson lesson) {
        this(lesson.getId());
    }
}

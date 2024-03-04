package responses.lessons;

import entities.Student;

import java.util.ArrayList;
import java.util.List;

public class AddLessonResponse {
    private long id;

    public AddLessonResponse(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

}

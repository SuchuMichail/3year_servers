package requests.lessons;

import java.beans.ConstructorProperties;

public class DeleteLessonRequest {
    private long id;

    @ConstructorProperties({"id"})
    public DeleteLessonRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

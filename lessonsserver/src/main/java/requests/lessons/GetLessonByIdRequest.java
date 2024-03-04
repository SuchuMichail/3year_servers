package requests.lessons;

import java.beans.ConstructorProperties;

public class GetLessonByIdRequest {
    private long id;

    @ConstructorProperties({"id"})
    public GetLessonByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

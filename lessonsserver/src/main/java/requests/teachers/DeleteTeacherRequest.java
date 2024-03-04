package requests.teachers;

import java.beans.ConstructorProperties;

public class DeleteTeacherRequest {
    private long id;

    @ConstructorProperties({"id"})
    public DeleteTeacherRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

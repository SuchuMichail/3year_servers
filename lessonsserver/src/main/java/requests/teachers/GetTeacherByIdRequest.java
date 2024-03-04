package requests.teachers;

import java.beans.ConstructorProperties;

public class GetTeacherByIdRequest {
    private long id;

    @ConstructorProperties({"id"})
    public GetTeacherByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

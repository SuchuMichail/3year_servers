package requests.students;

import java.beans.ConstructorProperties;

public class GetStudentsByGroupRequest {
    private long id;

    @ConstructorProperties({"id"})
    public GetStudentsByGroupRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

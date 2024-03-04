package requests.students;

import java.beans.ConstructorProperties;

public class GetStudentByIdRequest {
    private long id;

    @ConstructorProperties({"id"})
    public GetStudentByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

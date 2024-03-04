package requests.students;

import java.beans.ConstructorProperties;

public class DeleteStudentRequest {
    private long id;

    @ConstructorProperties({"id"})
    public DeleteStudentRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

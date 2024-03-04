package requests.student_groups;

import java.beans.ConstructorProperties;

public class DeleteStudentGroupRequest {
    private long id;

    @ConstructorProperties({"id"})
    public DeleteStudentGroupRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

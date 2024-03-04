package requests.student_groups;

import java.beans.ConstructorProperties;

public class GetStudentGroupByIdRequest {
    private long id;

    @ConstructorProperties({"id"})
    public GetStudentGroupByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

package requests.subjects;

import java.beans.ConstructorProperties;

public class DeleteSubjectRequest {
    private long id;

    @ConstructorProperties({"id"})
    public DeleteSubjectRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

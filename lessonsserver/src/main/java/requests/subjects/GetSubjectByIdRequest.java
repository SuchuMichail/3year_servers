package requests.subjects;

import java.beans.ConstructorProperties;

public class GetSubjectByIdRequest {
    private long id;

    @ConstructorProperties({"id"})
    public GetSubjectByIdRequest(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}

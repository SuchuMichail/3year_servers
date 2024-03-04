package requests.subjects;

import java.beans.ConstructorProperties;

public class EditSubjectRequest {
    private long id;
    private String name;

    @ConstructorProperties({"id","name"})
    public EditSubjectRequest(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

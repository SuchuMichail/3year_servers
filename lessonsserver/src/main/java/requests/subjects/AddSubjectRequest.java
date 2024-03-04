package requests.subjects;

import java.beans.ConstructorProperties;

public class AddSubjectRequest {
    private String name;

    @ConstructorProperties({"name"})
    public AddSubjectRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

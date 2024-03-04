package requests.student_groups;

import java.beans.ConstructorProperties;

public class AddStudentGroupRequest {
    private String name;

    @ConstructorProperties({"name"})
    public AddStudentGroupRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

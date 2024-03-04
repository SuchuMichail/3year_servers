package requests.student_groups;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.beans.ConstructorProperties;

public class EditStudentGroupRequest {
    private long id;
    private String name;

    @ConstructorProperties({"id","name"})
    public EditStudentGroupRequest(long id, String name) {
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

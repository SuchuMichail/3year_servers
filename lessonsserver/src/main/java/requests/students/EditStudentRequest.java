package requests.students;

import java.beans.ConstructorProperties;

public class EditStudentRequest {
    private long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private long groupId;
    private String status;

    @ConstructorProperties({"id","lastName","firstName","middleName","groupId","status"})
    public EditStudentRequest(long id, String lastName, String firstName, String middleName, long groupId, String status) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.groupId = groupId;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public long getGroupId() {
        return groupId;
    }

    public String getStatus() {
        return status;
    }

}

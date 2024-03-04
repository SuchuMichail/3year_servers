package requests.teachers;

import java.beans.ConstructorProperties;

public class EditTeacherRequest {
    private long id;
    private String lastName;
    private String firstName;
    private String middleName;

    @ConstructorProperties({"id","lastName","firstName","middleName"})
    public EditTeacherRequest(long id, String lastName, String firstName, String middleName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
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

}

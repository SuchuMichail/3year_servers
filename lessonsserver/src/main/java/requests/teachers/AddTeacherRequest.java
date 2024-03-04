package requests.teachers;

import java.beans.ConstructorProperties;

public class AddTeacherRequest {
    private String lastName;
    private String firstName;
    private String middleName;

    @ConstructorProperties({"lastName","firstName","middleName"})
    public AddTeacherRequest(String lastName, String firstName, String middleName) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
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

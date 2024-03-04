package responses.students;

import java.util.Objects;

public class GetStudentByIdResponse {
    private long id;
    private String lastName;
    private String firstName;
    private String middleName;
    private long groupId;
    private String status;

    public GetStudentByIdResponse(long id, String lastName, String firstName, String middleName, long groupId, String status) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetStudentByIdResponse response = (GetStudentByIdResponse) o;
        return id == response.id && groupId == response.groupId && Objects.equals(lastName, response.lastName) && Objects.equals(firstName, response.firstName) && Objects.equals(middleName, response.middleName) && Objects.equals(status, response.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, middleName, groupId, status);
    }
}

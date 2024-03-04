package responses.student_groups;

public class GetStudentGroupByIdResponse {
    private long id;
    private String name;

    public GetStudentGroupByIdResponse(long id, String name) {
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

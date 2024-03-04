package responses.subjects;

public class GetSubjectByIdResponse {
    private long id;
    private String name;

    public GetSubjectByIdResponse(long id, String name) {
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

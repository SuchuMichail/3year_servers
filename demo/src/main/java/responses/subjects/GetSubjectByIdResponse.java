package responses.subjects;

import entities.Subject;
import lombok.Data;

import java.beans.ConstructorProperties;

@Data
public class GetSubjectByIdResponse {
    private long id;
    private String name;

    @ConstructorProperties({"id", "name"})
    public GetSubjectByIdResponse(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public GetSubjectByIdResponse(Subject subject) {
        this(subject.getId(), subject.getName());
    }
}

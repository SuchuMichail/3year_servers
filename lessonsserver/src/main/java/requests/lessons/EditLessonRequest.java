package requests.lessons;

import java.beans.ConstructorProperties;

public class EditLessonRequest {
    private long id;
    private String startDate;
    private String endDate;
    private long groupId;
    private long teacherId;

    @ConstructorProperties({"id","startDate","endDate","groupId","teacherId"})
    public EditLessonRequest(long id, String startDate, String endDate, long groupId, long teacherId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupId = groupId;
        this.teacherId = teacherId;
    }

    public long getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public long getGroupId() {
        return groupId;
    }

    public long getTeacherId() {
        return teacherId;
    }
}

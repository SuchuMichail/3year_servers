package requests.lessons;

import java.beans.ConstructorProperties;

public class GetLessonsByTeacherRequest {
    private String startDate;
    private String endDate;
    private long teacherId;

    @ConstructorProperties({"startDate","endDate","teacherId"})
    public GetLessonsByTeacherRequest(String startDate, String endDate, long teacherId) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.teacherId = teacherId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public long getTeacherId() {
        return teacherId;
    }
}

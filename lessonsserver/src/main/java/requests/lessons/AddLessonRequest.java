package requests.lessons;

import entities.Student;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

public class AddLessonRequest {
    private String startDate;
    private String endDate;
    private long groupId;
    private long teacherId;

    private List<Student> attendance;

    @ConstructorProperties({"startDate","endDate","groupId","teacherId","attendance"})
    public AddLessonRequest(String startDate, String endDate, long groupId, long teacherId, List<Student> attendance) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupId = groupId;
        this.teacherId = teacherId;
        this.attendance = attendance;
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

    public List<Student> getAttendance() {
        return attendance;
    }
}

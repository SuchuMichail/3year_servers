package responses.lessons;

import java.util.List;

public class GetLessonByIdResponse {
    private long id;
    private String startDate;
    private String endDate;
    private String groupName;
    private String teacherLastName;
    private String teacherFirstName;
    private String teacherMiddleName;
    private List<Long> attendance;

    public GetLessonByIdResponse(long id, String startDate, String endDate, String groupName, String teacherLastName, String teacherFirstName, String teacherMiddleName, List<Long> attendance) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupName = groupName;
        this.teacherLastName = teacherLastName;
        this.teacherFirstName = teacherFirstName;
        this.teacherMiddleName = teacherMiddleName;
        this.attendance = attendance;
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

    public String getGroupName() {
        return groupName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public String getTeacherMiddleName() {
        return teacherMiddleName;
    }

    public List<Long> getAttendance() {
        return attendance;
    }
}

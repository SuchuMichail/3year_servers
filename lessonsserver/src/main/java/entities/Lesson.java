package entities;

import java.util.Objects;

public class Lesson {
    private Long id;
    private String startDate;
    private String endDate;
    private long groupId;
    private long teacherId;

    public Lesson(Long id, String startDate, String endDate, long groupId, long teacherId) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.groupId = groupId;
        this.teacherId = teacherId;
    }

    public Long getId() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson lesson = (Lesson) o;
        return groupId == lesson.groupId && teacherId == lesson.teacherId && Objects.equals(id, lesson.id) && Objects.equals(startDate, lesson.startDate) && Objects.equals(endDate, lesson.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDate, endDate, groupId, teacherId);
    }
}

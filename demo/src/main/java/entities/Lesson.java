package entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

@Data
@Entity
@Table(name = "lesson")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;

    @ManyToOne
    @JoinColumn(name = "id_group", referencedColumnName = "id")
    private StudentGroup group;

    @ManyToOne
    @JoinColumn(name = "id_teacher", referencedColumnName = "id")
    private Teacher teacher;

    public Lesson(Long id, String startDate, String endDate, StudentGroup group, Teacher teacher) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.group = group;
        this.teacher = teacher;
    }
}

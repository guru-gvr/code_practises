package src.main.java.com.learning.domain;

import javax.persistence.*;

@Entity
@Table(name = "course_material")
public class CourseMaterial {

    @Id
    @SequenceGenerator(name = "course_material_id_seq_gen", sequenceName = "course_material_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_material_id_seq_gen")
    private int courseMaterialId;

    private String url;

    @OneToOne
    @JoinColumn(name = "course_id",referencedColumnName = "courseId")
    private Course course;

    public int getCourseMaterialId() {
        return courseMaterialId;
    }

    public void setCourseMaterialId(int courseMaterialId) {
        this.courseMaterialId = courseMaterialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}

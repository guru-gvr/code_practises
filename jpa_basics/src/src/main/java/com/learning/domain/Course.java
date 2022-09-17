package src.main.java.com.learning.domain;

import javax.persistence.*;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @SequenceGenerator(name = "course_id_seq_gen", sequenceName = "course_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_id_seq_gen")
    private int courseId;
    private int credits;
    private String courseName;

    public Course(int courseId, int credits, String courseName) {
        this.courseId = courseId;
        this.credits = credits;
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Course() {
    }
    @OneToOne(mappedBy = "course")
    private CourseMaterial courseMaterial;
}


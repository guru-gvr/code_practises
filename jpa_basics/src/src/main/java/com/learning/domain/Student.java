package src.main.java.com.learning.domain;

import com.sun.jndi.toolkit.url.GenericURLContext;

import javax.persistence.*;

@Entity
@Table(name = "student_dtl",uniqueConstraints = @UniqueConstraint(name = "email_id_uni",columnNames = "email_address"))
public class Student {
    @Id
    @SequenceGenerator(name = "student_id_seq_gen",sequenceName = "student_id_seq",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "student_id_seq_gen")
    private Long id;
    private String name;
    private int age;
    @Column(name = "email_address",nullable = false)
    private String emailId;
    private String firstName;
    private String lastName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    @Embedded
    private Guardian guardian;


}

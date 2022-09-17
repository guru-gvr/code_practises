package src.main.java.com.learning.domain;

import javax.persistence.*;

@Embeddable
@AttributeOverrides({
@AttributeOverride(name = "mail", column = @Column(name = "guardian_mail")),
        @AttributeOverride(name = "name", column = @Column(name = "guardian_name")),
        @AttributeOverride(name = "mobile", column = @Column(name = "guardian_mobile")),

})
public class Guardian {
    private String mail;
    private String name;
    private String mobile;

    public Guardian() {
    }

    public Guardian(String mail, String name, String gmobile) {
        this.mail = mail;
        this.name = name;
        this.mobile = gmobile;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}

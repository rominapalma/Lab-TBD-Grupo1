package cl.tbd.backend.models;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

public class VolunteerMongo
{
    @Id private String id;
    private String name;
    private String email;
    private List<String> skill;
    private Date birthday;
    private String password;
    private Boolean availability;
    private Boolean delete;

    public VolunteerMongo(String id, String name, String email, List<String> skill, Date birthday, String password, Boolean availability, Boolean delete) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.skill = skill;
        this.birthday = birthday;
        this.password = password;
        this.availability = availability;
        this.delete = delete;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getSkill() {
        return skill;
    }

    public void setSkill(List<String> skill) {
        this.skill = skill;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}

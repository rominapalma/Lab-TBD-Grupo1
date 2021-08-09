package cl.tbd.backend.models;

public class VolunteerSkill {
    private Long id;
    private Long id_volunteer;
    private Long id_skill;
    private Boolean delete;

    public VolunteerSkill(Long id, Long id_volunteer, Long id_skill, Boolean delete) {
        this.id = id;
        this.id_volunteer = id_volunteer;
        this.id_skill = id_skill;
        this.delete = delete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_volunteer() {
        return id_volunteer;
    }

    public void setId_volunteer(Long id_volunteer) {
        this.id_volunteer = id_volunteer;
    }

    public Long getId_skill() {
        return id_skill;
    }

    public void setId_skill(Long id_skill) {
        this.id_skill = id_skill;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}

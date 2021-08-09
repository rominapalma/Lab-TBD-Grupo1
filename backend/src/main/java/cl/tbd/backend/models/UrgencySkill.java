package cl.tbd.backend.models;

public class UrgencySkill {
    private Long id;
    private Long id_urgency;
    private Long id_skill;
    private Boolean delete;

    public UrgencySkill(Long id, Long id_urgency, Long id_skill, Boolean delete) {
        this.id = id;
        this.id_urgency = id_urgency;
        this.id_skill = id_skill;
        this.delete = delete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_urgency() {
        return id_urgency;
    }

    public void setId_urgency(Long id_urgency) {
        this.id_urgency = id_urgency;
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

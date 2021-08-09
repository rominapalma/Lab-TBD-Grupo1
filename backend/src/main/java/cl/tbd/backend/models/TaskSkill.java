package cl.tbd.backend.models;

public class TaskSkill {
    private Long id;
    private Long id_task;
    private Long id_urgency_skill;
    private Boolean delete;

    public TaskSkill(Long id, Long id_task, Long id_urgency_skill, Boolean delete) {
        this.id = id;
        this.id_task = id_task;
        this.id_urgency_skill = id_urgency_skill;
        this.delete = delete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_task() {
        return id_task;
    }

    public void setId_task(Long id_task) {
        this.id_task = id_task;
    }

    public Long getId_urgency_skill() {
        return id_urgency_skill;
    }

    public void setId_urgency_skill(Long id_urgency_skill) {
        this.id_urgency_skill = id_urgency_skill;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}

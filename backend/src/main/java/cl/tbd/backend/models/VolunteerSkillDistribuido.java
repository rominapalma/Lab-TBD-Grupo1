package cl.tbd.backend.models;

public class VolunteerSkillDistribuido {
    private Long id;
    private int id_volunteer;
    private int id_skill;
    private String origin;
    private Boolean delete;

    public VolunteerSkillDistribuido(Long id, int id_volunteer, int id_skill, String origin, Boolean delete) {
        this.id = id;
        this.id_volunteer = id_volunteer;
        this.id_skill = id_skill;
        this.origin = origin;
        this.delete = delete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getId_volunteer() {
        return id_volunteer;
    }

    public void setId_volunteer(int id_volunteer) {
        this.id_volunteer = id_volunteer;
    }

    public int getId_skill() {
        return id_skill;
    }

    public void setId_skill(int id_skill) {
        this.id_skill = id_skill;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}

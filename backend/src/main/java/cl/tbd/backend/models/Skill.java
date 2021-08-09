package cl.tbd.backend.models;

public class Skill {
    private Long id;
    private String name;
    private String description;
    private Boolean delete;

    public Skill(Long id, String name, String description, Boolean delete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.delete = delete;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}

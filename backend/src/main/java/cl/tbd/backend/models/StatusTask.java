package cl.tbd.backend.models;

public class StatusTask {
    private Long id;
    private String description;
    private Boolean delete;

    public StatusTask(Long id, String description, Boolean delete) {
        this.id = id;
        this.description = description;
        this.delete = delete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

package cl.tbd.backend.models;
import org.springframework.data.annotation.Id;

public class SkillMongo {
    @Id private String id;
    private String name;
    private String description;
    private String code;
    private Boolean delete;

    public SkillMongo(String id, String name, String description, String code, Boolean delete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.code = code;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}

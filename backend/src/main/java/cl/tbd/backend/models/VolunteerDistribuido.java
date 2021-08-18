package cl.tbd.backend.models;


public class VolunteerDistribuido {
    private Long id;
    private String name;
    private String email;
    private String password;
    private Boolean availability;
    private Boolean delete;

    public VolunteerDistribuido(Long id, String name, String email, String password, Boolean availability, Boolean delete) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.availability = availability;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

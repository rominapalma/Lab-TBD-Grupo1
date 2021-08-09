package cl.tbd.backend.models;

public class Coordinator {
    private Long id;
    private String name;
    private Long id_institution;
    private double longitude;
    private double latitude;
    private Boolean delete;

    public Coordinator(Long id, String name, Long id_institution, double longitude, double latitude, Boolean delete) {
        this.id = id;
        this.name = name;
        this.id_institution = id_institution;
        this.longitude = longitude;
        this.latitude = latitude;
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

    public Long getId_institution() {
        return id_institution;
    }

    public void setId_institution(Long id_institution) {
        this.id_institution = id_institution;
    }

    public double getLongitude(){
        return longitude;
    }
    
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    public double getLatitude(){
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
    
    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}

package cl.tbd.backend.models;

import java.util.Date;

public class Urgency {
    private Long id;
    private String name;
    private String description;
    private Date start_date;
    private Date end_date;
    private Long id_coordinator;
    private double longitude;
    private double latitude;
    private Boolean delete;

    public Urgency(Long id, String name, String description, Date start_date, Date end_date, Long id_coordinator, double longitude, double latitude, Boolean delete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.id_coordinator = id_coordinator;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId_coordinator() {
        return id_coordinator;
    }

    public void setId_coordinator(Long id_coordinator) {
        this.id_coordinator = id_coordinator;
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

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}

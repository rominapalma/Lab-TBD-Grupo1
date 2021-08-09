package cl.tbd.backend.models;

public class VolunteerDistanceAux {
    private Long id;
    private String name;
    private int distance;
    private double longitude;
    private double latitude;
    private long number;
    private Boolean delete;

    public VolunteerDistanceAux(Long id, String name, int distance, double longitude, double latitude, long number, Boolean delete) {
        this.id = id;
        this.name = name;
        this.distance = distance;
        this.longitude = longitude;
        this.latitude = latitude;
        this.number = number;
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }
}

package cl.tbd.backend.models;

import java.util.Date;

public class UrgencyTaskAux {
    private Long id;
    private String name;
    private String description;
    private Date start_date;
    private Date end_date;
    private Long id_coordinator;
    private Boolean delete;
    private String status;
    private int num_vol_req;
    private int num_vol_signin;

    public UrgencyTaskAux(Long id, String name, String description, Date start_date, Date end_date, Long id_coordinator, Boolean delete, String status, int num_vol_req, int num_vol_signin) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.start_date = start_date;
        this.end_date = end_date;
        this.id_coordinator = id_coordinator;
        this.delete = delete;
        this.status = status;
        this.num_vol_req = num_vol_req;
        this.num_vol_signin = num_vol_signin;
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

    public int getNum_vol_req() {
        return num_vol_req;
    }

    public void setNum_vol_req(int num_vol_req) {
        this.num_vol_req = num_vol_req;
    }

    public int getNum_vol_signin() {
        return num_vol_signin;
    }

    public void setNum_vol_signin(int num_vol_signin) {
        this.num_vol_signin = num_vol_signin;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

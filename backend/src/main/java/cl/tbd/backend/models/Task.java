package cl.tbd.backend.models;

import java.util.Date;

public class Task {
    private Long id;
    private String name;
    private String description;
    private int num_vol_req;
    private int num_vol_signin;
    private Date start_date;
    private Date end_date;
    private Long id_urgency;
    private Long id_status_task;
    private Boolean delete;

    public Task(Long id, String name, String description, int num_vol_req, int num_vol_signin, Date start_date, Date end_date, Long id_urgency, Long id_status_task, Boolean delete) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.num_vol_req = num_vol_req;
        this.num_vol_signin = num_vol_signin;
        this.start_date = start_date;
        this.end_date = end_date;
        this.id_urgency = id_urgency;
        this.id_status_task = id_status_task;
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

    public Long getId_urgency() {
        return id_urgency;
    }

    public void setId_urgency(Long id_urgency) {
        this.id_urgency = id_urgency;
    }

    public Long getId_status_task() {
        return id_status_task;
    }

    public void setId_status_task(Long id_status_task) {
        this.id_status_task = id_status_task;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
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

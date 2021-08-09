package cl.tbd.backend.models;

public class Ranking {
    private Long id;
    private int score;
    private int flag_guest;
    private int flag_participate;
    private Long id_volunteer;
    private Long id_task;
    private Boolean delete;

    public Ranking(Long id, int score, int flag_guest, int flag_participate, Long id_volunteer, Long id_task, Boolean delete) {
        this.id = id;
        this.score = score;
        this.flag_guest = flag_guest;
        this.flag_participate = flag_participate;
        this.id_volunteer = id_volunteer;
        this.id_task = id_task;
        this.delete = delete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Long getId_volunteer() {
        return id_volunteer;
    }

    public void setId_volunteer(Long id_volunteer) {
        this.id_volunteer = id_volunteer;
    }

    public Long getId_task() {
        return id_task;
    }

    public void setId_task(Long id_task) {
        this.id_task = id_task;
    }

    public Boolean getDelete() {
        return delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    public int getFlag_guest() {
        return flag_guest;
    }

    public void setFlag_guest(int flag_guest) {
        this.flag_guest = flag_guest;
    }

    public int getFlag_participate() {
        return flag_participate;
    }

    public void setFlag_participate(int flag_participate) {
        this.flag_participate = flag_participate;
    }
}

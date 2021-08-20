package cl.tbd.backend.models;

public class SkillByVolunteerAuxDistribuido {
    private String name_volunteer;
    private String origin_volunteer;
    private String name_skill;
    private String origin_skill;

    public SkillByVolunteerAuxDistribuido(String name_volunteer, String origin_volunteer, String name_skill, String origin_skill) {
        this.name_volunteer = name_volunteer;
        this.origin_volunteer = origin_volunteer;
        this.name_skill = name_skill;
        this.origin_skill = origin_skill;
    }

    public String getName_volunteer() {
        return name_volunteer;
    }

    public void setName_volunteer(String name_volunteer) {
        this.name_volunteer = name_volunteer;
    }

    public String getOrigin_volunteer() {
        return origin_volunteer;
    }

    public void setOrigin_volunteer(String origin_volunteer) {
        this.origin_volunteer = origin_volunteer;
    }

    public String getName_skill() {
        return name_skill;
    }

    public void setName_skill(String name_skill) {
        this.name_skill = name_skill;
    }

    public String getOrigin_skill() {
        return origin_skill;
    }

    public void setOrigin_skill(String origin_skill) {
        this.origin_skill = origin_skill;
    }
}

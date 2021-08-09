package cl.tbd.backend.repositories;

import cl.tbd.backend.models.VolunteerSkill;

import java.util.List;

public interface VolunteerSkillRepository {
    public VolunteerSkill createVolunteerSkill(VolunteerSkill VolunteerSkillNew);
    public List<VolunteerSkill> findAllVolunteerSkill();
    public List<VolunteerSkill> findVolunteerSkillById(Long id);
    public VolunteerSkill updateVolunteerSkill(VolunteerSkill VolunteerSkillNew, Long idVolunteerSkill);
    public Boolean deleteVolunteerSkill(Long id);
}

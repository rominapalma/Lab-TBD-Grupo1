package cl.tbd.backend.repositories;

import cl.tbd.backend.models.UrgencySkill;

import java.util.List;

public interface UrgencySkillRepository {
    public UrgencySkill createUrgencySkill(UrgencySkill UrgencySkillNew);
    public List<UrgencySkill> findAllUrgencySkills();
    public List<UrgencySkill> findUrgencySkillById(Long id);
    public UrgencySkill updateUrgencySkill(UrgencySkill UrgencySkillNew, Long idUrgencySkill);
    public Boolean deleteUrgencySkill(Long id);
}

package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Skill;

import java.util.List;

public interface SkillRepository {
    public Skill createSkill(Skill SkillNew);
    public List<Skill> findAllSkills();
    public List<Skill> findSkillById(Long id);
    public Skill updateSkill(Skill SkillNew, Long idSkill);
    public Boolean deleteSkill( Long id);
}

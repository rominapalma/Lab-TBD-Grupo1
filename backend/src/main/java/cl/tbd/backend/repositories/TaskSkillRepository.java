package cl.tbd.backend.repositories;

import cl.tbd.backend.models.TaskSkill;

import java.util.List;

public interface TaskSkillRepository {
    public TaskSkill createTaskSkill(TaskSkill TaskSkillNew);
    public List<TaskSkill> findAllTaskSkills();
    public List<TaskSkill> findTaskSkillById(Long id);
    public TaskSkill updateTaskSkill(TaskSkill TaskSkillNew, Long idTaskSkill);
    public Boolean deleteTaskSkill(Long id);
}

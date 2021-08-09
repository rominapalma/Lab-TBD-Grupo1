package cl.tbd.backend.services;

import cl.tbd.backend.models.TaskSkill;
import cl.tbd.backend.repositories.TaskSkillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TaskSkillService {
    private final TaskSkillRepository taskSkillRepository;

    public TaskSkillService(TaskSkillRepository taskSkillRepository) {
        this.taskSkillRepository = taskSkillRepository;
    }

    @PostMapping("/taskSkill/")
    public TaskSkill createTaskSkill(@RequestBody TaskSkill taskSkillNew){
        return taskSkillRepository.createTaskSkill(taskSkillNew);
    }

    @GetMapping("/allTaskSkills")
    public List<TaskSkill> findAllTaskSkills() {
        return taskSkillRepository.findAllTaskSkills();
    }

    @GetMapping("/taskSkill/{id}")
    public List<TaskSkill> findTaskSkillById(@PathVariable Long id) {
        return taskSkillRepository.findTaskSkillById(id);
    }

    @PutMapping("/taskSkill/{id}/")
    @ResponseBody
    public TaskSkill updateTaskSkill(TaskSkill taskSkillNew) {
        return taskSkillRepository.updateTaskSkill(taskSkillNew, taskSkillNew.getId());
    }

    @DeleteMapping("/taskSkill/{id}")
    public boolean deleteTaskSkill(@PathVariable Long id){
        return taskSkillRepository.deleteTaskSkill(id);
    }
}

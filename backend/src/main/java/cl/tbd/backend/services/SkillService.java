package cl.tbd.backend.services;

import cl.tbd.backend.models.Skill;
import cl.tbd.backend.repositories.SkillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }
    @PostMapping("/skill")
    public Skill createSkill(@RequestBody Skill skillNew){
        return skillRepository.createSkill(skillNew);
    }
    @GetMapping("/allSkills")
    public List<Skill> findAllSkills() {
        return skillRepository.findAllSkills();
    }
    @GetMapping("/skill/{id}")
    public List<Skill> findSkillById(@PathVariable Long id) {
        return skillRepository.findSkillById(id);
    }
    @PutMapping("/skill/{id}")
    @ResponseBody
    public Skill updateSkill(Skill skillNew){
        return skillRepository.updateSkill(skillNew, skillNew.getId());
    }

    @DeleteMapping("/skill/{id}")
    public boolean deleteSkill(@PathVariable Long id){
        return skillRepository.deleteSkill(id);
    }
}

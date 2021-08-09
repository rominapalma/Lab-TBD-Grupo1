package cl.tbd.backend.services;

import cl.tbd.backend.models.UrgencySkill;
import cl.tbd.backend.repositories.UrgencySkillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UrgencySkillService {
    private final UrgencySkillRepository urgencySkillRepository;

    public UrgencySkillService(UrgencySkillRepository urgencySkillRepository) {
        this.urgencySkillRepository = urgencySkillRepository;
    }

    @PostMapping("/urgencySkill")
    public UrgencySkill createUrgencySkill(@RequestBody UrgencySkill urgencySkillNew){
        return urgencySkillRepository.createUrgencySkill(urgencySkillNew);
    }

    @GetMapping("/allUrgencySkills")
    public List<UrgencySkill> findAllUrgencySkills() {
        return urgencySkillRepository.findAllUrgencySkills();
    }

    @GetMapping("/urgencySkill/{id}")
    public List<UrgencySkill> findUrgencySkillById(@PathVariable Long id) {
        return urgencySkillRepository.findUrgencySkillById(id);
    }

    @PutMapping("/urgencySkill/{id}")
    @ResponseBody
    public UrgencySkill updateUrgencySkill(UrgencySkill urgencySkillNew){
        return urgencySkillRepository.updateUrgencySkill(urgencySkillNew, urgencySkillNew.getId());
    }

    @DeleteMapping("/urgencySkill/{id}")
    public boolean deleteUrgencySkill(@PathVariable Long id){
        return urgencySkillRepository.deleteUrgencySkill(id);
    }
}

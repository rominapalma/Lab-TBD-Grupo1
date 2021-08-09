package cl.tbd.backend.services;

import cl.tbd.backend.models.VolunteerSkill;
import cl.tbd.backend.repositories.VolunteerSkillRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class VolunteerSkillService {
    private final VolunteerSkillRepository volunteerSkillRepository;

    public VolunteerSkillService(VolunteerSkillRepository volunteerSkillRepository) {
        this.volunteerSkillRepository = volunteerSkillRepository;
    }

    @PostMapping("/volunteerSkill/")
    public VolunteerSkill createInstitution(@RequestBody VolunteerSkill volunteerSkillNew){
        return volunteerSkillRepository.createVolunteerSkill(volunteerSkillNew);
    }
    
    @GetMapping("/allVolunteerSkill")
    public List<VolunteerSkill> findAllVolunteerSkill() {
        return volunteerSkillRepository.findAllVolunteerSkill();
    }

    @GetMapping("/volunteerSkill/{id}")
    public List<VolunteerSkill> findVolunteerSkillById(@PathVariable Long id) {
        return volunteerSkillRepository.findVolunteerSkillById(id);
    }
    
    @PutMapping("/volunteerSkill/{id}")
    @ResponseBody
    public VolunteerSkill updateInstitution(VolunteerSkill volunteerSkillNew){
        return volunteerSkillRepository.updateVolunteerSkill(volunteerSkillNew, volunteerSkillNew.getId());
    }

    @DeleteMapping("/volunteerSkill/{id}")
    public boolean deleteInstitution(@PathVariable Long id){
        return volunteerSkillRepository.deleteVolunteerSkill(id);
    }
}

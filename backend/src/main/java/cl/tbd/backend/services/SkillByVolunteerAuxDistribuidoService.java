package cl.tbd.backend.services;

import cl.tbd.backend.models.SkillByVolunteerAuxDistribuido;
import cl.tbd.backend.repositories.SkillByVolunteerAuxDistribuidoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class SkillByVolunteerAuxDistribuidoService {
    public final SkillByVolunteerAuxDistribuidoRepository skillByVolunteerAuxDistribuidoRepository;
    public SkillByVolunteerAuxDistribuidoService(SkillByVolunteerAuxDistribuidoRepository skillByVolunteerAuxDistribuidoRepository) {
        this.skillByVolunteerAuxDistribuidoRepository = skillByVolunteerAuxDistribuidoRepository;
    }

    @GetMapping("/skillByVolunteer/")
    public List<SkillByVolunteerAuxDistribuido> skillByVolunteer(){
        return skillByVolunteerAuxDistribuidoRepository.skillByVolunteer();
    }
}

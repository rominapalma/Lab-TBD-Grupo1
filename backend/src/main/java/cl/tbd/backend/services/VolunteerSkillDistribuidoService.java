package cl.tbd.backend.services;

import cl.tbd.backend.models.VolunteerSkillDistribuido;
import cl.tbd.backend.repositories.VolunteerSkillDistribuidoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class VolunteerSkillDistribuidoService {
    private final VolunteerSkillDistribuidoRepository volunteerSkillDistribuidoRepository;

    public VolunteerSkillDistribuidoService(VolunteerSkillDistribuidoRepository volunteerSkillDistribuidoRepository) {
        this.volunteerSkillDistribuidoRepository = volunteerSkillDistribuidoRepository;
    }

    @PostMapping("/volunteerSkillDistribuido/")
    public VolunteerSkillDistribuido createVolunteerSkillDistribuido(VolunteerSkillDistribuido volunteerSkillNew) {
        return volunteerSkillDistribuidoRepository.createVolunteerSkillDistribuido(volunteerSkillNew);
    }

    @GetMapping("/allVolunteerSkillDistribuido")
    public List<VolunteerSkillDistribuido> findAllVolunteerSkillDistribuido() {
        return volunteerSkillDistribuidoRepository.findAllVolunteerSkillDistribuido();
    }


    @GetMapping("/volunteerSkillDistribuido/{id}")
    public List<VolunteerSkillDistribuido> findAllVolunteerSkillDistribuidoById(@PathVariable Long id) {
        return volunteerSkillDistribuidoRepository.findAllVolunteerSkillDistribuidoById(id);
    }

    @PutMapping("/volunteerSkillDistribuido/{id}/")
    @ResponseBody
    public VolunteerSkillDistribuido updateVolunteerSkillDistribuido(VolunteerSkillDistribuido volunteerNew, @PathVariable Long id) {
        return volunteerSkillDistribuidoRepository.updateVolunteerSkillDistribuido(volunteerNew, id);
    }

    @DeleteMapping("/volunteerSkillDistribuido/{id}/")
    public Boolean deleteVolunteerSkillDistribuido(@PathVariable Long id) {
        return volunteerSkillDistribuidoRepository.deleteVolunteerSkillDistribuido(id);
    }
}

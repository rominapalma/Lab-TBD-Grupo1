package cl.tbd.backend.services;

import cl.tbd.backend.models.VolunteerDistribuido;
import cl.tbd.backend.repositories.VolunteerDistribuidoRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class VolunteerDistribuidoService {
    private final VolunteerDistribuidoRepository volunteerDistribuidoRepository;

    public VolunteerDistribuidoService(VolunteerDistribuidoRepository volunteerDistribuidoRepository) {
        this.volunteerDistribuidoRepository = volunteerDistribuidoRepository;
    }

    @PostMapping("/volunteerDistribuido/")
    public VolunteerDistribuido createVolunteer(VolunteerDistribuido volunteerNew) {
        return volunteerDistribuidoRepository.createVolunteerDistribuido(volunteerNew);
    }


    @GetMapping("/allVolunteerDistribuido")
    public List<VolunteerDistribuido> findAllVolunteer() {
        return volunteerDistribuidoRepository.findAllVolunteerDistribuido();
    }

    @GetMapping("/volunteerDistribuido/{id}")
    public List<VolunteerDistribuido> findAllVolunteerById(@PathVariable Long id) {
        return volunteerDistribuidoRepository.findAllVolunteerDistribuidoById(id);
    }

    @PutMapping("/volunteerDistribuido/{id}/")
    @ResponseBody
    public VolunteerDistribuido updateVolunteer(VolunteerDistribuido volunteerNew, @PathVariable Long id) {
        return volunteerDistribuidoRepository.updateVolunteerDistribuido(volunteerNew, id);
    }

    @DeleteMapping("/volunteerDistribuido/{id}/")
    public Boolean deleteVolunteer(@PathVariable Long id) {
        return volunteerDistribuidoRepository.deleteVolunteerDistribuido(id);
    }
}

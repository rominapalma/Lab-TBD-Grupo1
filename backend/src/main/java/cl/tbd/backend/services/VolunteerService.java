package cl.tbd.backend.services;

import cl.tbd.backend.models.Volunteer;
import cl.tbd.backend.repositories.VolunteerRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class VolunteerService {
    private final VolunteerRepository volunteerRepository;

    public VolunteerService(VolunteerRepository volunteerRepository) {
        this.volunteerRepository = volunteerRepository;
    }

    @PostMapping("/volunteer/")
    // Esto significa que el retorno de este llamado se transforma a un formato tipo
    // JSON o XML (segun se indique) generalmente usaremos json
    public Volunteer createVolunteer(@RequestBody Volunteer volunteerNew) { // Aqui va un "@RequestBody, pero para
                                                                            // efectos de postman se lo sacamos
        return volunteerRepository.createVolunteer(volunteerNew);
    }

    @GetMapping("/volunteer/urgency/{id}")
    public List<Volunteer> getLocationVolunteersByUrgency(@PathVariable Long id) {
        return volunteerRepository.getLocationVolunteersByUrgency(id);
    }

    @GetMapping("/allVolunteer")
    public List<Volunteer> findAllVolunteer() {
        return volunteerRepository.findAllVolunteer();
    }

    @GetMapping("/volunteer/{id}")
    public List<Volunteer> findAllVolunteerById(@PathVariable Long id) {
        return volunteerRepository.findAllVolunteerById(id);
    }

    @PutMapping("/volunteer/{id}/")
    @ResponseBody
    public Volunteer updateVolunteer(Volunteer volunteerNew, @PathVariable Long idVolunteer) {
        return volunteerRepository.updateVolunteer(volunteerNew, idVolunteer);
    }

    @DeleteMapping("/volunteer/{id}/")
    public Boolean deleteVolunteer(@PathVariable Long id) {
        return volunteerRepository.deleteVolunteer(id);
    }
}

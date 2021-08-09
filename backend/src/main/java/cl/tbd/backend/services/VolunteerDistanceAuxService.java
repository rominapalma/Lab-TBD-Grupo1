package cl.tbd.backend.services;

import cl.tbd.backend.models.VolunteerDistanceAux;
import cl.tbd.backend.repositories.VolunteerDistanceAuxRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class VolunteerDistanceAuxService {
    private final VolunteerDistanceAuxRepository volunteerDistanceAuxRepository;

    public VolunteerDistanceAuxService(VolunteerDistanceAuxRepository volunteerDistanceAuxRepository) {
        this.volunteerDistanceAuxRepository = volunteerDistanceAuxRepository;
    }
    @GetMapping("/volunteerDistance/{latitude}/{longitude}/{number}")
    public List<VolunteerDistanceAux> volunteerDistance(@PathVariable double latitude, @PathVariable double longitude, @PathVariable long number) {
        return volunteerDistanceAuxRepository.volunteerDistance(latitude, longitude, number);
    }
}

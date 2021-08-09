package cl.tbd.backend.services;

import cl.tbd.backend.models.Urgency;
import cl.tbd.backend.repositories.UrgencyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UrgencyService {
    private final UrgencyRepository urgencyRepository;

    public UrgencyService(UrgencyRepository urgencyRepository) {
        this.urgencyRepository = urgencyRepository;
    }

    @PostMapping("/urgency")
    public Urgency createUrgency(@RequestBody Urgency urgencyNew) {
        return urgencyRepository.createUrgency(urgencyNew);
    }

    @GetMapping("/allUrgencies")
    public List<Urgency> findAllUrgencies() {
        return urgencyRepository.findAllUrgencies();
    }

    @GetMapping("/urgency/{id}")
    public List<Urgency> findUrgencyById(@PathVariable Long id) {
        return urgencyRepository.findUrgencyById(id);
    }

    @PutMapping("/urgency/{id}")
    @ResponseBody
    public Urgency updateUrgency(Urgency urgencyNew) {
        return urgencyRepository.updateUrgency(urgencyNew, urgencyNew.getId());
    }

    @DeleteMapping("/urgency/{id}")
    public boolean deleteUrgency(@PathVariable Long id) {
        return urgencyRepository.deleteUrgency(id);
    }
}

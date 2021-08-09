package cl.tbd.backend.services;

import cl.tbd.backend.models.UrgencyTaskAux;
import cl.tbd.backend.repositories.UrgencyTaskAuxRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UrgencyTaskAuxService {
    private final UrgencyTaskAuxRepository urgencyTaskAuxRepository;

    public UrgencyTaskAuxService(UrgencyTaskAuxRepository urgencyTaskAuxRepository) {
        this.urgencyTaskAuxRepository = urgencyTaskAuxRepository;
    }

    @GetMapping("/urgency/{id}/taskStatus")
    public List<UrgencyTaskAux> viewDetailsUrgencyById(@PathVariable Long id) {
        return urgencyTaskAuxRepository.viewDetailsUrgencyById(id);
    }

}

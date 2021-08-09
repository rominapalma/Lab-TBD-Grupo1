package cl.tbd.backend.services;

import cl.tbd.backend.models.Coordinator;
import cl.tbd.backend.repositories.CoordinatorRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class CoordinatorService {
    private final CoordinatorRepository coordinatorRepository;

    public CoordinatorService(CoordinatorRepository coordinatorRepository) {
        this.coordinatorRepository = coordinatorRepository;
    }

    @PostMapping("/coordinator/")
    public Coordinator createCoordinator(@RequestBody Coordinator coordinatorNew){
        return coordinatorRepository.createCoordinator(coordinatorNew);
    }

    @GetMapping("/allCoordinators")
    public List<Coordinator> findAllCoordinators() {
        return coordinatorRepository.findAllCoordinators();
    }

    @GetMapping("/coordinators/{id}")
    public List<Coordinator> findCoordinatorById(@PathVariable Long id) {
        return coordinatorRepository.findCoordinatorById(id);
    }

    @GetMapping("/coordinator/institution/{id}")
    public List<Coordinator> findCoordinatorByInstitution(@PathVariable Long id){
        return coordinatorRepository.findCoordinatorByInstitution(id);
    }

    @PutMapping("/coordinators/{id}")
    @ResponseBody
    public Coordinator updateCoordinator(@RequestBody Coordinator coordinatorNew){
        return coordinatorRepository.updateCoordinator(coordinatorNew, coordinatorNew.getId());
    }

    @DeleteMapping("/coordinator/{id}")
    public boolean deleteCoordinator(@PathVariable Long id){
        return coordinatorRepository.deleteCoordinator(id);
    }
}

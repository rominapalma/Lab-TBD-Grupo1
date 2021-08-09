package cl.tbd.backend.services;

import cl.tbd.backend.models.UrgencyDetailAux;
import cl.tbd.backend.repositories.TaskRepository;
import cl.tbd.backend.repositories.UrgencyDetailAuxRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UrgencyDetailAuxService {
    private final UrgencyDetailAuxRepository urgencyDetailAuxRepository;

    public UrgencyDetailAuxService(UrgencyDetailAuxRepository urgencyDetailAuxRepository) {
        this.urgencyDetailAuxRepository = urgencyDetailAuxRepository;
    }

    @PostMapping("/urgencyDetailAux/")
    public UrgencyDetailAux createUrgencyDetailAux(@RequestBody UrgencyDetailAux UrgencyDetailAuxNew){
        return urgencyDetailAuxRepository.createUrgencyDetailAux(UrgencyDetailAuxNew);
    }

    @GetMapping("/allUrgencyDetailAux")
    public List<UrgencyDetailAux> findAllUrgencyDetailAux(){
        return urgencyDetailAuxRepository.findAllUrgencyDetailAux();
    }

    @GetMapping("/urgencyDetailAux/{id}")
    public List<UrgencyDetailAux> findUrgencyDetailAuxById(@PathVariable Long id) {
        return urgencyDetailAuxRepository.findUrgencyDetailAuxById(id);
    }

    @PutMapping("/urgencyDetailAux/{id}/")
    @ResponseBody
    public UrgencyDetailAux updateUrgencyDetailAux(UrgencyDetailAux urgencyDetailAuxNew){
        return urgencyDetailAuxRepository.updateUrgencyDetailAux(urgencyDetailAuxNew, urgencyDetailAuxNew.getId());
    }

    @DeleteMapping("/urgencyDetailAux/{id}")
    public boolean deleteUrgencyDetailAux(@PathVariable Long id){
        return urgencyDetailAuxRepository.deleteUrgencyDetailAux(id);
    }
}

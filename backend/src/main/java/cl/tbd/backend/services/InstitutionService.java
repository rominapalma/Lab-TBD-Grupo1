package cl.tbd.backend.services;

import cl.tbd.backend.models.Institution;
import cl.tbd.backend.repositories.InstitutionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class InstitutionService {
    private final InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @PostMapping("/institution/")
    public Institution createInstitution(@RequestBody Institution institutionNew){
        return institutionRepository.createInstitution(institutionNew);
    }

    @GetMapping("/allInstitutions")
    public List<Institution> findAllInstitutions() {
        return institutionRepository.findAllInstitutions();
    }

    @GetMapping("/institution/{id}")
    public List<Institution> findInstitutionById(@PathVariable Long id) {
        return institutionRepository.findInstitutionById(id);
    }

    @PutMapping("/institution/{id}")
    @ResponseBody
    public Institution updateInstitution(Institution institutionNew){
        return institutionRepository.updateInstitution(institutionNew, institutionNew.getId());
    }

    @DeleteMapping("/institution/{id}")
    public boolean deleteInstitution(@PathVariable Long id){
        return institutionRepository.deleteInstitution(id);
    }
}

package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Institution;

import java.util.List;

public interface InstitutionRepository {
    public Institution createInstitution(Institution InstitutionNew);
    public List<Institution> findAllInstitutions();
    public List<Institution> findInstitutionById(Long id);
    public Institution updateInstitution(Institution InstitutionNew, Long idInstitution);
    public Boolean deleteInstitution(Long id);
}

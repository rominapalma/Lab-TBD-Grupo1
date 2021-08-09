package cl.tbd.backend.repositories;

import cl.tbd.backend.models.UrgencyDetailAux;

import java.util.List;

public interface UrgencyDetailAuxRepository {
    public UrgencyDetailAux createUrgencyDetailAux(UrgencyDetailAux UrgencyDetailAuxNew);
    public List<UrgencyDetailAux> findAllUrgencyDetailAux();
    public List<UrgencyDetailAux> findUrgencyDetailAuxById(Long id);
    public UrgencyDetailAux updateUrgencyDetailAux(UrgencyDetailAux UrgencyDetailAuxNew, Long idUrgencyDetailAux);
    public Boolean deleteUrgencyDetailAux(Long id);
}

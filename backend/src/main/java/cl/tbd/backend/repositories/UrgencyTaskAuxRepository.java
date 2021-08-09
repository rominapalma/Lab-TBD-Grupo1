package cl.tbd.backend.repositories;

import cl.tbd.backend.models.UrgencyTaskAux;

import java.util.List;

public interface UrgencyTaskAuxRepository {
    public List<UrgencyTaskAux> viewDetailsUrgencyById(Long id);
}

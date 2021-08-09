package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Urgency;
import java.util.List;

public interface UrgencyRepository {
    public Urgency createUrgency(Urgency UrgencyNew);

    public List<Urgency> findAllUrgencies();

    public List<Urgency> findUrgencyById(Long id);

    public Urgency updateUrgency(Urgency UrgencyNew, Long idUrgency);

    public Boolean deleteUrgency(Long id);
}

package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Volunteer;
import cl.tbd.backend.models.VolunteerDistribuido;

import java.util.List;

public interface VolunteerDistribuidoRepository {
    public VolunteerDistribuido createVolunteerDistribuido(VolunteerDistribuido VolunteerNew);

    public List<VolunteerDistribuido> findAllVolunteerDistribuido();

    public List<VolunteerDistribuido> findAllVolunteerDistribuidoById(Long id);

    public VolunteerDistribuido updateVolunteerDistribuido(VolunteerDistribuido VolunteerNew, Long idVolunteer);

    public Boolean deleteVolunteerDistribuido(Long id);
}

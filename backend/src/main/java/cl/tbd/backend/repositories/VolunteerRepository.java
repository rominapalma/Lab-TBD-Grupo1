package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Volunteer;

import java.util.List;

public interface VolunteerRepository {
    public Volunteer createVolunteer(Volunteer VolunteerNew);

    public List<Volunteer> findAllVolunteer();

    public List<Volunteer> findAllVolunteerById(Long id);

    public List<Volunteer> getLocationVolunteersByUrgency(Long id);

    public Volunteer updateVolunteer(Volunteer VolunteerNew, Long idVolunteer);

    public Boolean deleteVolunteer(Long id);
}

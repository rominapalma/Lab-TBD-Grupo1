package cl.tbd.backend.repositories;

import cl.tbd.backend.models.VolunteerSkillDistribuido;

import java.util.List;

public interface VolunteerSkillDistribuidoRepository {
    public VolunteerSkillDistribuido createVolunteerSkillDistribuido(VolunteerSkillDistribuido VolunteerNew);

    public List<VolunteerSkillDistribuido> findAllVolunteerSkillDistribuido();

    public List<VolunteerSkillDistribuido> findAllVolunteerSkillDistribuidoById(Long id);

    public VolunteerSkillDistribuido updateVolunteerSkillDistribuido(VolunteerSkillDistribuido VolunteerNew, Long idVolunteer);

    public Boolean deleteVolunteerSkillDistribuido(Long id);
}

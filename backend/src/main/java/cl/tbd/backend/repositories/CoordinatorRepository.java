package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Coordinator;

import java.util.List;

public interface CoordinatorRepository {
    public Coordinator createCoordinator(Coordinator CoordinatorNew);
    public List<Coordinator> findAllCoordinators();
    public List<Coordinator> findCoordinatorById(Long id);
    public Coordinator updateCoordinator(Coordinator CoordinatorNew, Long idCoordinator);
    public Boolean deleteCoordinator(Long id);
    public List<Coordinator> findCoordinatorByInstitution(Long id);
}

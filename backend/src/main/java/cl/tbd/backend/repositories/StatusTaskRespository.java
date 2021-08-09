package cl.tbd.backend.repositories;

import cl.tbd.backend.models.StatusTask;

import java.util.List;

public interface StatusTaskRespository {
    public StatusTask createStatusTask(StatusTask TaskNew);
    public List<StatusTask> findAllStatusTasks();
    public List<StatusTask> findStatusTaskById(Long id);
    public StatusTask updateStatusTask(StatusTask StatusTaskNew, Long idTask);
    public Boolean deleteStatusTask(Long id);
}

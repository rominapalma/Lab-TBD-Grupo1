package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Task;

import java.util.List;

public interface TaskRepository {
    public Task createTask(Task TaskNew);
    public List<Task> findAllTasks();
    public List<Task> findTaskById(Long id);
    public Task updateTask(Task TaskNew, Long idTask);
    public Boolean deleteTask(Long id);
}

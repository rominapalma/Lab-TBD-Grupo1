package cl.tbd.backend.services;

import cl.tbd.backend.models.Task;
import cl.tbd.backend.repositories.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @PostMapping("/task/")
    public Task createTask(@RequestBody Task taskNew){
        return taskRepository.createTask(taskNew);
    }
    @GetMapping("/allTasks")
    public List<Task> findAllTasks() {
        return taskRepository.findAllTasks();
    }
    @GetMapping("/task/{id}")
    public List<Task> findTaskById(@PathVariable Long id) {
        return taskRepository.findTaskById(id);
    }
    @PutMapping("/task/{id}/")
    @ResponseBody
    public Task updateTask(Task taskNew){
        return taskRepository.updateTask(taskNew, taskNew.getId());
    }

    @DeleteMapping("/task/{id}")
    public boolean deleteTask(@PathVariable Long id){
        return taskRepository.deleteTask(id);
    }
}

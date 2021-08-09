package cl.tbd.backend.services;

import cl.tbd.backend.models.StatusTask;
import cl.tbd.backend.repositories.StatusTaskRespository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class StatusTaskService {
    private final StatusTaskRespository statusTaskRespository;

    public StatusTaskService(StatusTaskRespository statusTaskRespository) {
        this.statusTaskRespository = statusTaskRespository;
    }
    @PostMapping("/statusTask")
    public StatusTask createStatusTask(@RequestBody StatusTask statusTaskNew){
        return statusTaskRespository.createStatusTask(statusTaskNew);
    }
    @GetMapping("/allStatusTask")
    public List<StatusTask> findAllStatusTasks() {
        return statusTaskRespository.findAllStatusTasks();
    }
    @GetMapping("/statusTasks/{id}")
    public List<StatusTask> findStatusTaskById(@PathVariable Long id) {
        return statusTaskRespository.findStatusTaskById(id);
    }
    @PutMapping("/statusTasks/{id}")
    @ResponseBody
    public StatusTask updateStatusTask(StatusTask statusTaskNew){
        return statusTaskRespository.updateStatusTask(statusTaskNew, statusTaskNew.getId());
    }

    @DeleteMapping("/statusTask/{id}")
    public boolean deleteStatusTask(@PathVariable Long id){
        return statusTaskRespository.deleteStatusTask(id);
    }
}

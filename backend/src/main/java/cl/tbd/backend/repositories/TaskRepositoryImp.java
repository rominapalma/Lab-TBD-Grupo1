package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TaskRepositoryImp implements TaskRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Task createTask(Task TaskNew) {
        Long idNew = lastId() + 1;
        try(Connection conn = sql2o.open()){
            Long insertedId =  conn.createQuery("INSERT INTO task (id,name, description, num_vol_req, num_vol_signin, start_date, end_date, id_urgency, id_status_task, delete) values (:id,:name, :description, :num_vol_req, :num_vol_signin , :start_date, :end_date, :id_urgency, :id_status_task, :delete)", true)
                    .addParameter("id", idNew)
                    .addParameter("name", TaskNew.getName())
                    .addParameter("description", TaskNew.getDescription())
                    .addParameter("num_vol_req", TaskNew.getNum_vol_req())
                    .addParameter("num_vol_signin", TaskNew.getNum_vol_signin())
                    .addParameter("start_date", TaskNew.getStart_date())
                    .addParameter("end_date", TaskNew.getEnd_date())
                    .addParameter("id_urgency", TaskNew.getId_urgency())
                    .addParameter("id_status_task", TaskNew.getId_status_task())
                    .addParameter("delete", TaskNew.getDelete())
                    .executeUpdate().getKey(Long.class);
            TaskNew.setId(insertedId);
            TaskNew.setDelete(false);
            return TaskNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Task> findAllTasks() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select id,name, description, num_vol_req, num_vol_signin, start_date, end_date, id_urgency, id_status_task, delete from task where delete = false")
                    .executeAndFetch(Task.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Task> findTaskById(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select id,name, description, num_vol_req, num_vol_signin, start_date, end_date, id_urgency, id_status_task, delete from task where task.id = :id and delete=false")
                    .addParameter("id", id)
                    .executeAndFetch(Task.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Task updateTask(Task TaskNew, Long idTask) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE task SET name = :name, description = :description, id_urgency = :id_urgency, num_vol_req = :num_vol_req, num_vol_signin = :numvol_signin, id_status_task = :id_status_task, delete = :delete WHERE id = :id and delete=false", true)
                    .addParameter("id",TaskNew.getId())
                    .addParameter("name",TaskNew.getName())
                    .addParameter("description",TaskNew.getDescription())
                    .addParameter("num_vol_req", TaskNew.getNum_vol_req())
                    .addParameter("num_vol_signin", TaskNew.getNum_vol_signin())
                    .addParameter("id_urgency",TaskNew.getId_urgency())
                    .addParameter("id_status_task",TaskNew.getId_status_task())
                    .addParameter("delete", TaskNew.getDelete())
                    .executeUpdate();
            return TaskNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteTask(Long id) {
        try(Connection con = sql2o.open()) {
            id = (Long) con.createQuery("UPDATE task SET delete = true WHERE id = :id and delete=false",true)
                    .addParameter("id",id)
                    .executeUpdate().getKey();
            return (id!=null);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return id==null;
        }
    }

    public Long lastId(){
        Long lastId;
        try(Connection conn = sql2o.open()){
            lastId = Long.parseLong(String.valueOf(conn.createQuery("select max(task.id) from task", true)
                    .executeScalar(long.class)));
            return lastId;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }
}

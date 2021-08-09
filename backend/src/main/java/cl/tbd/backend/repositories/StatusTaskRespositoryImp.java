package cl.tbd.backend.repositories;

import cl.tbd.backend.models.StatusTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class StatusTaskRespositoryImp implements StatusTaskRespository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public StatusTask createStatusTask(StatusTask StatusTaskNew) {
        Long idNew = lastId() + 1;
        try(Connection conn = sql2o.open()){
            Long insertedId =  conn.createQuery("INSERT INTO status_task (id,description, delete) values (:id,:description, :delete)", true)
                    .addParameter("id", idNew)
                    .addParameter("description", StatusTaskNew.getDescription())
                    .addParameter("delete", StatusTaskNew.getDelete())
                    .executeUpdate().getKey(Long.class);
            StatusTaskNew.setId(insertedId);
            return StatusTaskNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<StatusTask> findAllStatusTasks() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select id,description, delete from status_task where delete = false")
                    .executeAndFetch(StatusTask.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<StatusTask> findStatusTaskById(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select id,description, delete from status_task where status_task.id = :id and delete=false")
                    .addParameter("id", id)
                    .executeAndFetch(StatusTask.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public StatusTask updateStatusTask(StatusTask StatusTaskNew, Long idTask) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE status_task SET description = :description, delete = :delete WHERE id = :id and delete=false", true)
                    .addParameter("id",StatusTaskNew.getId())
                    .addParameter("description",StatusTaskNew.getDescription())
                    .addParameter("delete", StatusTaskNew.getDelete())
                    .executeUpdate();
            return StatusTaskNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteStatusTask(Long id) {
        try(Connection con = sql2o.open()) {
            id = (Long) con.createQuery("UPDATE status_task SET delete = true WHERE id = :id and delete=false",true)
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
            lastId = Long.parseLong(String.valueOf(conn.createQuery("select max(status_task.id) from status_task", true)
                    .executeScalar(long.class)));
            return lastId;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }
}

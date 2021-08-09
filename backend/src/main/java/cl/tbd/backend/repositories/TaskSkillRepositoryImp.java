package cl.tbd.backend.repositories;

import cl.tbd.backend.models.TaskSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TaskSkillRepositoryImp implements TaskSkillRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public TaskSkill createTaskSkill(TaskSkill TaskSkillNew) {
        Long idNew = lastId() + 1;
        try(Connection conn = sql2o.open()){
            Long insertedId =  conn.createQuery("INSERT INTO task_skill (id, id_task, id_urgency_skill, delete ) values (:id, :id_task, :id_urgency_skill, :delete)", true)
                    .addParameter("id", idNew)
                    .addParameter("id_task", TaskSkillNew.getId_task())
                    .addParameter("id_urgency_skill", TaskSkillNew.getId_urgency_skill())
                    .addParameter("delete", TaskSkillNew.getDelete())
                    .executeUpdate().getKey(Long.class);
            TaskSkillNew.setId(insertedId);
            TaskSkillNew.setDelete(false);
            return TaskSkillNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TaskSkill> findAllTaskSkills() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select id, id_task, id_urgency_skill, delete from task_skill where delete = false")
                    .executeAndFetch(TaskSkill.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<TaskSkill> findTaskSkillById(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select id, id_task, id_urgency_skill, delete from task_skill where task_skill.id = :id and delete=false")
                    .addParameter("id", id)
                    .executeAndFetch(TaskSkill.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public TaskSkill updateTaskSkill(TaskSkill TaskSkillNew, Long idTaskSkill) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE task_skill SET id_task = :id_task, id_urgency_skill = :id_urgency_skill, delete = :delete WHERE id = :id and delete=false", true)
                    .addParameter("id",TaskSkillNew.getId())
                    .addParameter("id_task", TaskSkillNew.getId_task())
                    .addParameter("id_urgency_skill", TaskSkillNew.getId_urgency_skill())
                    .addParameter("delete", TaskSkillNew.getDelete())
                    .executeUpdate();
            return TaskSkillNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteTaskSkill(Long id) {
        try(Connection con = sql2o.open()) {
            id = (Long) con.createQuery("UPDATE task_skill SET delete = true WHERE id = :id and delete=false",true)
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
            lastId = Long.parseLong(String.valueOf(conn.createQuery("select max(task_skill.id) from task_skill", true)
                    .executeScalar(long.class)));
            return lastId;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }
}

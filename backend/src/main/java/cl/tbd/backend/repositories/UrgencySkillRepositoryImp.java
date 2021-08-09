package cl.tbd.backend.repositories;

import cl.tbd.backend.models.UrgencySkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UrgencySkillRepositoryImp implements UrgencySkillRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public UrgencySkill createUrgencySkill(UrgencySkill UrgencySkillNew) {
        Long idNew = lastId() + 1;
        try(Connection conn = sql2o.open()){
            Long insertedId =  conn.createQuery("INSERT INTO urgency_skill (id, id_urgency,id_skill, delete) values (:id, :id_urgency, :id_skill, :delete)", true)
                    .addParameter("id", idNew)
                    .addParameter("id_urgency", UrgencySkillNew.getId_urgency())
                    .addParameter("id_skill", UrgencySkillNew.getId_skill())
                    .addParameter("delete", UrgencySkillNew.getDelete())
                    .executeUpdate().getKey(Long.class);
            UrgencySkillNew.setId(insertedId);
            return UrgencySkillNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<UrgencySkill> findAllUrgencySkills() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select id, id_urgency,id_skill, delete from urgency_skill where delete = false")
                    .executeAndFetch(UrgencySkill.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<UrgencySkill> findUrgencySkillById(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select id, id_urgency,id_skill, delete from urgency_skill where urgency_skill.id = :id and delete=false")
                    .addParameter("id", id)
                    .executeAndFetch(UrgencySkill.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UrgencySkill updateUrgencySkill(UrgencySkill UrgencySkillNew, Long idUrgencySkill) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE urgency_skill SET id_urgency = :id_urgency, id_skill = :id_skill, delete = :delete WHERE id = :id and delete=false", true)
                    .addParameter("id",UrgencySkillNew.getId())
                    .addParameter("id_urgency", UrgencySkillNew.getId_urgency())
                    .addParameter("id_skill", UrgencySkillNew.getId_skill())
                    .addParameter("delete", UrgencySkillNew.getDelete())
                    .executeUpdate();
            return UrgencySkillNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteUrgencySkill(Long id) {
        try(Connection con = sql2o.open()) {
            id = (Long) con.createQuery("UPDATE urgency_skill SET delete = true WHERE id = :id and delete=false",true)
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
            lastId = Long.parseLong(String.valueOf(conn.createQuery("select max(urgency_skill.id) from urgency_skill", true)
                    .executeScalar(long.class)));
            return lastId;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }
}

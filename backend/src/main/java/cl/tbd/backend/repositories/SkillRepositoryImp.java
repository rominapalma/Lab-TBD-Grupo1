package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class SkillRepositoryImp implements SkillRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Skill createSkill(Skill SkillNew) {
        try(Connection conn = sql2o.open()){
            Long idNew = lastId() + 1;
            Long insertedId =  conn.createQuery("INSERT INTO skill (id,name,description,delete) values (:id, :name, :description, :delete)", true)
                    .addParameter("id", idNew)
                    .addParameter("name", SkillNew.getName())
                    .addParameter("description", SkillNew.getDescription())
                    .addParameter("delete", SkillNew.getDelete())
                    .executeUpdate().getKey(Long.class);
            SkillNew.setId(insertedId);
            SkillNew.setDelete(false);
            return SkillNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Skill> findAllSkills() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select id,name,description,delete from skill where delete = false")
                    .executeAndFetch(Skill.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Skill> findSkillById(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select id,name,description,delete from skill where skill.id = :id and delete=false")
                    .addParameter("id", id)
                    .executeAndFetch(Skill.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Skill updateSkill(Skill SkillNew, Long idSkill) {
        try(Connection conn = sql2o.open()){
            String.valueOf(conn.createQuery("UPDATE skill SET name = :name, description = :description, delete = :delete WHERE id = :id and delete=false", true)
                    .addParameter("id",SkillNew.getId())
                    .addParameter("name", SkillNew.getName())
                    .addParameter("description",SkillNew.getDescription())
                    .addParameter("delete", SkillNew.getDelete())
                    .executeUpdate());
            return SkillNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteSkill(Long id) {
        try(Connection con = sql2o.open()) {
            id = (Long) con.createQuery("UPDATE skill SET delete = true WHERE id = :id and delete=false",true)
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
            lastId = Long.parseLong(String.valueOf(conn.createQuery("select max(skill.id) from skill", true)
                    .executeScalar(long.class)));
            return lastId;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }
}

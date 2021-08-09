package cl.tbd.backend.repositories;

import cl.tbd.backend.models.VolunteerSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VolunteerSkillRepositoryImp implements VolunteerSkillRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public VolunteerSkill createVolunteerSkill(VolunteerSkill VolunteerSkillNew) {
        Long idNew = lastId() + 1;
        try(Connection conn = sql2o.open()){
            Long insertedId =  conn.createQuery("INSERT INTO Volunteer_skill (id, id_Volunteer, id_skill, delete) values (:id, :id_Volunteer, :id_skill, :delete)", true)
                    .addParameter("id", idNew)
                    .addParameter("id_Volunteer", VolunteerSkillNew.getId_volunteer())
                    .addParameter("id_skill", VolunteerSkillNew.getId_skill())
                    .addParameter("delete", VolunteerSkillNew.getDelete())
                    .executeUpdate().getKey(Long.class);
            VolunteerSkillNew.setId(insertedId);
            VolunteerSkillNew.setDelete(false);
            return VolunteerSkillNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VolunteerSkill> findAllVolunteerSkill() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select * from Volunteer_skill where delete = false")
                    .executeAndFetch(VolunteerSkill.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VolunteerSkill> findVolunteerSkillById(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select Volunteer_skill.* from Volunteer_skill where Volunteer_skill.id = :id and delete=false")
                    .addParameter("id", id)
                    .executeAndFetch(VolunteerSkill.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public VolunteerSkill updateVolunteerSkill(VolunteerSkill VolunteerSkillNew, Long idVolunteerSkill) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE Volunteer_skill SET id_Volunteer = :id_Volunteer, id_skill = :id_skill, delete = :delete WHERE id = :id and delete=false", true)
                    .addParameter("id",VolunteerSkillNew.getId())
                    .addParameter("id_Volunteer",VolunteerSkillNew.getId_volunteer())
                    .addParameter("id_skill", VolunteerSkillNew.getId_skill())
                    .addParameter("delete", VolunteerSkillNew.getDelete())
                    .executeUpdate();
            return VolunteerSkillNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteVolunteerSkill(Long id) {
        try(Connection con = sql2o.open()) {
            id = (Long) con.createQuery("UPDATE volunteer_skill SET delete = true WHERE id = :id and delete=false",true)
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
            lastId = Long.parseLong(String.valueOf(conn.createQuery("select max(Volunteer_skill.id) from Volunteer_skill", true)
                    .executeScalar(long.class)));
            return lastId;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }
}

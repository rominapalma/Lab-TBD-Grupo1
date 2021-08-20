package cl.tbd.backend.repositories;

import cl.tbd.backend.models.VolunteerSkill;
import cl.tbd.backend.models.VolunteerSkillDistribuido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VolunteerSkillDistribuidoRepositoryImp implements VolunteerSkillDistribuidoRepository{
    @Autowired
    private Sql2o sql2o;

    public Long FuncionHash(Long id){
        return id % 3;
    }

    @Override
    public VolunteerSkillDistribuido createVolunteerSkillDistribuido(VolunteerSkillDistribuido VolunteerSkillNew) {
        Long idNew = lastId() + 1;
        Long idHash = FuncionHash(idNew);
        String sql = null;
        try(Connection conn = sql2o.open()){
            if(idHash == 0){
                sql = "INSERT INTO Volunteer_skill0 (id, id_Volunteer, id_skill, origin, delete) values (:id, :id_Volunteer, :id_skill, :origin, :delete)";
                Long insertedId =  conn.createQuery(sql, true)
                        .addParameter("id", idNew)
                        .addParameter("id_Volunteer", VolunteerSkillNew.getId_volunteer())
                        .addParameter("id_skill", VolunteerSkillNew.getId_skill())
                        .addParameter("origin", "volunteer_skill0")
                        .addParameter("delete", VolunteerSkillNew.getDelete())
                        .executeUpdate().getKey(Long.class);
                VolunteerSkillNew.setId(insertedId);
                VolunteerSkillNew.setOrigin("volunteer_skill0");
                VolunteerSkillNew.setDelete(false);
                return VolunteerSkillNew;
            }
            else if(idHash == 1){
                sql = "INSERT INTO Volunteer_skill1 (id, id_Volunteer, id_skill, origin, delete) values (:id, :id_Volunteer, :id_skill, :origin, :delete)";
                Long insertedId =  conn.createQuery(sql, true)
                        .addParameter("id", idNew)
                        .addParameter("id_Volunteer", VolunteerSkillNew.getId_volunteer())
                        .addParameter("id_skill", VolunteerSkillNew.getId_skill())
                        .addParameter("origin", "volunteer_skill1")
                        .addParameter("delete", VolunteerSkillNew.getDelete())
                        .executeUpdate().getKey(Long.class);
                VolunteerSkillNew.setId(insertedId);
                VolunteerSkillNew.setOrigin("volunteer_skill1");
                VolunteerSkillNew.setDelete(false);
                return VolunteerSkillNew;
            }
            sql = "INSERT INTO Volunteer_skill2 (id, id_Volunteer, id_skill, origin, delete) values (:id, :id_Volunteer, :id_skill, :origin, :delete)";
            Long insertedId =  conn.createQuery(sql, true)
                    .addParameter("id", idNew)
                    .addParameter("id_Volunteer", VolunteerSkillNew.getId_volunteer())
                    .addParameter("id_skill", VolunteerSkillNew.getId_skill())
                    .addParameter("origin", "volunteer_skill2")
                    .addParameter("delete", VolunteerSkillNew.getDelete())
                    .executeUpdate().getKey(Long.class);
            VolunteerSkillNew.setId(insertedId);
            VolunteerSkillNew.setOrigin("volunteer_skill2");
            VolunteerSkillNew.setDelete(false);
            return VolunteerSkillNew;

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VolunteerSkillDistribuido> findAllVolunteerSkillDistribuido() {
        String sql = "select Volunteer_skill0.* from volunteer_skill0 where volunteer_skill0.delete = false "
                + "UNION ALL select Volunteer_skill1.* from volunteer_skill1 where volunteer_skill1.delete = false "
                + "UNION ALL select Volunteer_skill2.* from volunteer_skill2 where volunteer_skill2.delete = false ORDER BY id";
        try(Connection conn = sql2o.open()){
            return conn.createQuery(sql)
                    .executeAndFetch(VolunteerSkillDistribuido.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VolunteerSkillDistribuido> findAllVolunteerSkillDistribuidoById(Long id) {
        Long idHash = FuncionHash(id);
        String sql = null;
        if(idHash == 0){
            sql = "select Volunteer_skill0.* from Volunteer_skill0 where Volunteer_skill0.id = :id and delete=false";
            try (Connection conn = sql2o.open()) {
                return conn.createQuery(sql)
                        .addParameter("id", id)
                        .executeAndFetch(VolunteerSkillDistribuido.class);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        else if(idHash == 1){
            sql = "select Volunteer_skill1.* from Volunteer_skill1 where Volunteer_skill1.id = :id and delete=false";
            try (Connection conn = sql2o.open()) {
                return conn.createQuery(sql)
                        .addParameter("id", id)
                        .executeAndFetch(VolunteerSkillDistribuido.class);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        sql = "select Volunteer_skill2.* from Volunteer_skill2 where Volunteer_skill2.id = :id and delete=false";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(VolunteerSkillDistribuido.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }


    }

    @Override
    public VolunteerSkillDistribuido updateVolunteerSkillDistribuido(VolunteerSkillDistribuido VolunteerSkillNew, Long idVolunteerSkill) {
        Long idHash = FuncionHash(idVolunteerSkill);
        String sql = null;
        try(Connection conn = sql2o.open()){
            if(idHash == 0) {
                sql = "UPDATE Volunteer_skill0 SET id_Volunteer = :id_Volunteer, id_skill = :id_skill, delete = :delete WHERE id = :id and delete=false";
            }
            else if(idHash == 1){
                sql = "UPDATE Volunteer_skill1 SET id_Volunteer = :id_Volunteer, id_skill = :id_skill, delete = :delete WHERE id = :id and delete=false";
            }
            else if(idHash == 2){
                sql = "UPDATE Volunteer_skill2 SET id_Volunteer = :id_Volunteer, id_skill = :id_skill, delete = :delete WHERE id = :id and delete=false";
            }
            conn.createQuery(sql, true)
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
    public Boolean deleteVolunteerSkillDistribuido(Long id) {
        Long idHash = FuncionHash(id);
        try(Connection con = sql2o.open()) {
            if(idHash == 0){
                id = (Long) con.createQuery("UPDATE volunteer_skill0 SET delete = true WHERE id = :id and delete=false",true)
                        .addParameter("id",id)
                        .executeUpdate().getKey();
                return (id!=null);
            }
            else if(idHash == 1){
                id = (Long) con.createQuery("UPDATE volunteer_skill1 SET delete = true WHERE id = :id and delete=false",true)
                        .addParameter("id",id)
                        .executeUpdate().getKey();
                return (id!=null);
            }
            id = (Long) con.createQuery("UPDATE volunteer_skill1 SET delete = true WHERE id = :id and delete=false",true)
                    .addParameter("id",id)
                    .executeUpdate().getKey();
            return (id!=null);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return id==null;
        }
    }

    public Long lastId() {
        Long lastId0;
        Long lastId1;
        Long lastId2;

        try (Connection conn = sql2o.open()) {
            lastId0 = Long.parseLong(
                    String.valueOf(conn.createQuery("select max(volunteer_skill0.id) from volunteer_skill0 WHERE delete=false", true)
                            .executeScalar(long.class)));
            lastId1 = Long.parseLong(
                    String.valueOf(conn.createQuery("select max(volunteer_skill1.id) from volunteer_skill1 WHERE delete=false", true)
                            .executeScalar(long.class)));
            lastId2 = Long.parseLong(
                    String.valueOf(conn.createQuery("select max(volunteer_skill2.id) from volunteer_skill2 WHERE delete=false", true)
                            .executeScalar(long.class)));
            if(lastId0 > lastId1 && lastId0 > lastId2) return lastId0;
            else if(lastId1 > lastId0 && lastId1 > lastId2) return lastId1;
            return lastId2;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }
}

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
                        .addParameter("delete", false)
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
                        .addParameter("delete", false)
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
                    .addParameter("delete", false)
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
        String sql = "select volunteer_skill0.*\n" +
                "from volunteer_skill0\n" +
                "where volunteer_skill0.delete = false\n" +
                "UNION ALL\n" +
                "select volunteer_skill1.*\n" +
                "from volunteer_skill1\n" +
                "where volunteer_skill1.delete = false\n" +
                "UNION ALL\n" +
                "select volunteer_skill2.*\n" +
                "from volunteer_skill2\n" +
                "where volunteer_skill2.delete = false\n" +
                "ORDER BY id";
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
            sql = "select * from volunteer_skill0 where id = :id and delete = false";
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
            sql = "select * from volunteer_skill1 where id = :id and delete = false";
            try (Connection conn = sql2o.open()) {
                return conn.createQuery(sql)
                        .addParameter("id", id)
                        .executeAndFetch(VolunteerSkillDistribuido.class);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        sql = "select * from volunteer_skill2 where id = :id and delete = false";
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
    public VolunteerSkillDistribuido updateVolunteerSkillDistribuido(VolunteerSkillDistribuido VolunteerSkillNew, Long id) {
        Long idHash = FuncionHash(id);
        String sql = null;
        try(Connection conn = sql2o.open()){
            if(idHash == 0) {
                sql = "UPDATE Volunteer_skill0 SET id_Volunteer = :id_Volunteer, id_skill = :id_skill, origin = :origin, delete = :delete WHERE id = :id ";
                conn.createQuery(sql, true)
                        .addParameter("id",VolunteerSkillNew.getId())
                        .addParameter("id_Volunteer",VolunteerSkillNew.getId_volunteer())
                        .addParameter("id_skill", VolunteerSkillNew.getId_skill())
                        .addParameter("origin", "Volunteer_skill0")
                        .addParameter("delete", VolunteerSkillNew.getDelete())
                        .executeUpdate();
                VolunteerSkillNew.setOrigin("Volunteer_skill0");
                return VolunteerSkillNew;
            }
            else if(idHash == 1){
                sql = "UPDATE Volunteer_skill1 SET id_Volunteer = :id_Volunteer, id_skill = :id_skill, origin = :origin, delete = :delete WHERE id = :id ";
                conn.createQuery(sql, true)
                        .addParameter("id",VolunteerSkillNew.getId())
                        .addParameter("id_Volunteer",VolunteerSkillNew.getId_volunteer())
                        .addParameter("id_skill", VolunteerSkillNew.getId_skill())
                        .addParameter("origin", "Volunteer_skill1")
                        .addParameter("delete", VolunteerSkillNew.getDelete())
                        .executeUpdate();
                VolunteerSkillNew.setOrigin("Volunteer_skill1");
                return VolunteerSkillNew;
            }
            sql = "UPDATE Volunteer_skill2 SET id_Volunteer = :id_Volunteer, id_skill = :id_skill, origin = :origin, delete = :delete WHERE id = :id ";
            conn.createQuery(sql, true)
                    .addParameter("id",VolunteerSkillNew.getId())
                    .addParameter("id_Volunteer",VolunteerSkillNew.getId_volunteer())
                    .addParameter("id_skill", VolunteerSkillNew.getId_skill())
                    .addParameter("origin", "Volunteer_skill2")
                    .addParameter("delete", VolunteerSkillNew.getDelete())
                    .executeUpdate();
            VolunteerSkillNew.setOrigin("Volunteer_skill2");
            return VolunteerSkillNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteVolunteerSkillDistribuido(Long id) {
            Long idHash = FuncionHash(id);
            try (Connection con = sql2o.open()) {
                if(idHash == 0){
                    id = (Long) con.createQuery("UPDATE volunteer_skill0 SET delete = true WHERE id = :id and delete=false", true)
                            .addParameter("id", id)
                            .executeUpdate().getKey();
                    return (id != null);
                }
                else if(idHash == 1){
                    id = (Long) con.createQuery("UPDATE volunteer_skill1 SET delete = true WHERE id = :id and delete=false", true)
                            .addParameter("id", id)
                            .executeUpdate().getKey();
                    return (id != null);
                }
                id = (Long) con.createQuery("UPDATE volunteer_skill2 SET delete = true WHERE id = :id and delete=false", true)
                        .addParameter("id", id)
                        .executeUpdate().getKey();
                return (id != null);


            } catch (Exception e) {
                System.out.println(e.getMessage());
                return id == null;
            }
        }

    public Long lastId() {
        Long lastId0;
        Long lastId1;
        Long lastId2;

        try (Connection conn = sql2o.open()) {
            lastId0 = Long.parseLong(
                    String.valueOf(conn.createQuery("select max(volunteer_skill0.id) from volunteer_skill0", true)
                            .executeScalar(long.class)));
            lastId1 = Long.parseLong(
                    String.valueOf(conn.createQuery("select max(volunteer_skill1.id) from volunteer_skill1", true)
                            .executeScalar(long.class)));
            lastId2 = Long.parseLong(
                    String.valueOf(conn.createQuery("select max(volunteer_skill2.id) from volunteer_skill2", true)
                            .executeScalar(long.class)));
            if(lastId0 > lastId1 && lastId0 > lastId2) return lastId0;
            else if(lastId1 > lastId0 && lastId1 > lastId2) return lastId1;
            else return lastId2;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }
}

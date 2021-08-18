package cl.tbd.backend.repositories;

import cl.tbd.backend.models.VolunteerDistribuido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VolunteerDistribuidoRepositoryImp implements VolunteerDistribuidoRepository {
    @Autowired
    private Sql2o sql2o;

    public Long FuncionHash(Long id){
        return id % 3;
    }

    @Override
    public VolunteerDistribuido createVolunteerDistribuido(VolunteerDistribuido VolunteerNew) {
        Long idNew = lastId() + 1;
        Long idHash = FuncionHash(idNew);
        String sql;
        try (Connection conn = sql2o.open()) {
            if(idHash == 0){
                sql = "INSERT INTO volunteer0 (id, name, email, password, availability, delete) values (:id, :name, :email, :password, :availability, :delete)";
                Long insertedId = conn.createQuery(sql, true)
                        .addParameter("id", idNew)
                        .addParameter("name", VolunteerNew.getName())
                        .addParameter("email", VolunteerNew.getEmail())
                        .addParameter("password", VolunteerNew.getPassword())
                        .addParameter("availability", VolunteerNew.getAvailability())
                        .addParameter("delete", VolunteerNew.getDelete())
                        .executeUpdate().getKey(Long.class);
                VolunteerNew.setId(insertedId);
                VolunteerNew.setDelete(false);
                return VolunteerNew;
            }
            else if(idHash == 1){
                sql = "INSERT INTO volunteer1 (id, name, email,password, availability, delete) values (:id, :name, :email, :password, :availability, :delete)";
                Long insertedId = conn.createQuery(sql, true)
                        .addParameter("id", idNew)
                        .addParameter("name", VolunteerNew.getName())
                        .addParameter("email", VolunteerNew.getEmail())
                        .addParameter("password", VolunteerNew.getPassword())
                        .addParameter("availability", VolunteerNew.getAvailability())
                        .addParameter("delete", VolunteerNew.getDelete())
                        .executeUpdate().getKey(Long.class);
                VolunteerNew.setId(insertedId);
                VolunteerNew.setDelete(false);
                return VolunteerNew;
            }
            sql = "INSERT INTO volunteer2 (id, name, email, password, availability, delete) values (:id, :name, :email, :password, :availability, :delete)";
            Long insertedId = conn.createQuery(sql, true)
                    .addParameter("id", idNew)
                    .addParameter("name", VolunteerNew.getName())
                    .addParameter("email", VolunteerNew.getEmail())
                    .addParameter("password", VolunteerNew.getPassword())
                    .addParameter("availability", VolunteerNew.getAvailability())
                    .addParameter("delete", VolunteerNew.getDelete())
                    .executeUpdate().getKey(Long.class);
            VolunteerNew.setId(insertedId);
            VolunteerNew.setDelete(false);
            return VolunteerNew;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VolunteerDistribuido> findAllVolunteerDistribuido() {
        String sql = "select volunteer0.* from volunteer0 where volunteer0.delete = false "
                + "UNION ALL select volunteer1.* from volunteer1 where volunteer1.delete = false "
                + "UNION ALL select volunteer2.* from volunteer2 where volunteer2.delete = false ORDER BY id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(VolunteerDistribuido.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<VolunteerDistribuido> findAllVolunteerDistribuidoById(Long id) {
        Long idHash = FuncionHash(id);

        if(idHash == 0){
            try (Connection conn = sql2o.open()) {
                return conn.createQuery(
                        "select id, name, email, password, availability, delete from volunteer0 where volunteer0.id = :id and delete=false")
                        .addParameter("id", id)
                        .executeAndFetch(VolunteerDistribuido.class);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        else if(idHash == 1){
            try (Connection conn = sql2o.open()) {
                return conn.createQuery(
                        "select id, name, email, password, availability, delete from volunteer1 where volunteer1.id = :id and delete=false")
                        .addParameter("id", id)
                        .executeAndFetch(VolunteerDistribuido.class);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(
                    "select id, name, email, password, availability, delete from volunteer2 where volunteer2.id = :id and delete=false")
                    .addParameter("id", id)
                    .executeAndFetch(VolunteerDistribuido.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }


    }

    @Override
    public VolunteerDistribuido updateVolunteerDistribuido(VolunteerDistribuido VolunteerNew, Long idVolunteer) {
        Long idHash = FuncionHash(idVolunteer);
        String sql = null;
        try (Connection conn = sql2o.open()) {
            if(idHash == 0) {
                sql = "UPDATE volunteer0 SET name = :name, email = :email, password = :password, availability = :availability, delete = :delete WHERE id = :id and delete=false";
                conn.createQuery(sql, true).addParameter("id", VolunteerNew.getId())
                        .addParameter("name", VolunteerNew.getName())
                        .addParameter("email", VolunteerNew.getEmail())
                        .addParameter("password", VolunteerNew.getPassword())
                        .addParameter("availability", VolunteerNew.getAvailability())
                        .addParameter("delete", VolunteerNew.getDelete())
                        .executeUpdate();
                return VolunteerNew;
            }
            else if(idHash == 1){
                sql = "UPDATE volunteer1 SET name = :name, email = :email, password = :password, availability = :availability, delete = :delete WHERE id = :id and delete=false";
                conn.createQuery(sql, true).addParameter("id", VolunteerNew.getId())
                        .addParameter("name", VolunteerNew.getName())
                        .addParameter("email", VolunteerNew.getEmail())
                        .addParameter("password", VolunteerNew.getPassword())
                        .addParameter("availability", VolunteerNew.getAvailability())
                        .addParameter("delete", VolunteerNew.getDelete())
                        .executeUpdate();
                return VolunteerNew;
            }
            sql = "UPDATE volunteer2 SET name = :name, email = :email, password = :password, availability = :availability, delete = :delete WHERE id = :id and delete=false";
            conn.createQuery(sql, true).addParameter("id", VolunteerNew.getId())
                    .addParameter("name", VolunteerNew.getName())
                    .addParameter("email", VolunteerNew.getEmail())
                    .addParameter("password", VolunteerNew.getPassword())
                    .addParameter("availability", VolunteerNew.getAvailability())
                    .addParameter("delete", VolunteerNew.getDelete())
                    .executeUpdate();
            return VolunteerNew;


        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteVolunteerDistribuido(Long id) {
        Long idHash = FuncionHash(id);
        try (Connection con = sql2o.open()) {
            if(idHash == 0){
                id = (Long) con.createQuery("UPDATE volunteer0 SET delete = true WHERE id = :id and delete=false", true)
                        .addParameter("id", id)
                        .executeUpdate().getKey();
                return (id != null);
            }
            else if(idHash == 1){
                id = (Long) con.createQuery("UPDATE volunteer1 SET delete = true WHERE id = :id and delete=false", true)
                        .addParameter("id", id)
                        .executeUpdate().getKey();
                return (id != null);
            }
            id = (Long) con.createQuery("UPDATE volunteer2 SET delete = true WHERE id = :id and delete=false", true)
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
                    String.valueOf(conn.createQuery("select max(volunteer0.id) from volunteer0 WHERE delete=false", true)
                            .executeScalar(long.class)));
            lastId1 = Long.parseLong(
                    String.valueOf(conn.createQuery("select max(volunteer1.id) from volunteer1 WHERE delete=false", true)
                            .executeScalar(long.class)));
            lastId2 = Long.parseLong(
                    String.valueOf(conn.createQuery("select max(volunteer2.id) from volunteer2 WHERE delete=false", true)
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

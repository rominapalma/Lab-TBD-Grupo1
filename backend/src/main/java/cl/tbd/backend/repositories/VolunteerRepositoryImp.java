package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VolunteerRepositoryImp implements VolunteerRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Volunteer createVolunteer(Volunteer VolunteerNew) {
        Long idNew = lastId() + 1;
        try (Connection conn = sql2o.open()) {
            String location = "POINT(" + VolunteerNew.getLongitude() + " " + VolunteerNew.getLatitude() + ")";
            String sql = "INSERT INTO volunteer (id, name, email, birthday, password, availability, location, delete) values (:id, :name, :email, :birthday, :password, :availability, ST_GeomFromText(:location, 4326), :delete)";
            Long insertedId = conn.createQuery(sql, true).addParameter("id", idNew)
                    .addParameter("name", VolunteerNew.getName())
                    .addParameter("email", VolunteerNew.getEmail())
                    .addParameter("birthday", VolunteerNew.getBirthday())
                    .addParameter("password", VolunteerNew.getPassword())
                    .addParameter("availability", VolunteerNew.getAvailability())
                    .addParameter("location", location)
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

    public List<Volunteer> getLocationVolunteersByUrgency(Long id) {
        String sql = "select v.id as id, v.name as name, v.availability as availability, st_y(st_astext(location)) AS latitude, st_x(st_astext(location)) AS longitude from volunteer as v join ranking on v.id = ranking.id_volunteer join task on task.id = ranking.id_task where v.delete = false and task.id_urgency = :id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql).addParameter("id", id).executeAndFetch(Volunteer.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Volunteer> findAllVolunteer() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(
                    "select id, name, email, birthday, password, availability, st_y(st_astext(location)) AS latitude, st_x(st_astext(location)) AS longitude, delete from volunteer where delete = false")
                    .executeAndFetch(Volunteer.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Volunteer> findAllVolunteerById(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(
                    "select id, name, email, birthday, password, availability, st_y(st_astext(location)) AS latitude, st_x(st_astext(location)) AS longitude, delete from volunteer where volunteer.id = :id and delete=false")
                    .addParameter("id", id).executeAndFetch(Volunteer.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Volunteer updateVolunteer(Volunteer VolunteerNew, Long idVolunteer) {
        try (Connection conn = sql2o.open()) {
            String location = "POINT(" + VolunteerNew.getLongitude() + " " + VolunteerNew.getLatitude() + ", 4326)";
            String sql = "UPDATE volunteer SET name = :name, email = :email, birthday = :birthday, password = :password, availability = :availability, location = :location, delete = :delete WHERE id = :id and delete=false";
            conn.createQuery(sql, true).addParameter("id", VolunteerNew.getId())
                    .addParameter("name", VolunteerNew.getName())
                    .addParameter("email", VolunteerNew.getEmail())
                    .addParameter("birthday", VolunteerNew.getBirthday())
                    .addParameter("password", VolunteerNew.getPassword())
                    .addParameter("availability", VolunteerNew.getAvailability())
                    .addParameter("location", location)
                    .addParameter("delete", VolunteerNew.getDelete())
                    .executeUpdate();
            return VolunteerNew;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteVolunteer(Long id) {
        try (Connection con = sql2o.open()) {
            id = (Long) con.createQuery("UPDATE volunteer SET delete = true WHERE id = :id and delete=false", true)
                    .addParameter("id", id).executeUpdate().getKey();
            return (id != null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return id == null;
        }
    }

    public Long lastId() {
        Long lastId;
        try (Connection conn = sql2o.open()) {
            lastId = Long.parseLong(
                    String.valueOf(conn.createQuery("select max(volunteer.id) from volunteer WHERE delete=false", true)
                            .executeScalar(long.class)));
            return lastId;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }
}

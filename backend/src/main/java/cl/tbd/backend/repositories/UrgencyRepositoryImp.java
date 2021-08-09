package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Urgency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UrgencyRepositoryImp implements UrgencyRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public Urgency createUrgency(Urgency UrgencyNew) {
        Long idNew = lastId() + 1;
        try (Connection conn = sql2o.open()) {
            String location = "POINT("+UrgencyNew.getLongitude()+" "+UrgencyNew.getLatitude()+")";

            String sql = "INSERT INTO urgency (id, name, description, start_date, end_date, location, id_coordinator, delete) values (:id, :name, :description, :start_date, :end_date, ST_GeomFromText(:location, 4326), :id_coordinator, :delete)";
            Long insertedId = conn.createQuery(sql, true)
                    .addParameter("id", idNew)
                    .addParameter("name", UrgencyNew.getName())
                    .addParameter("description", UrgencyNew.getDescription())
                    .addParameter("start_date", UrgencyNew.getStart_date())
                    .addParameter("end_date", UrgencyNew.getEnd_date())
                    .addParameter("location", location)
                    .addParameter("id_coordinator", UrgencyNew.getId_coordinator())
                    .addParameter("delete", UrgencyNew.getDelete())
                    .executeUpdate().getKey(Long.class);

            UrgencyNew.setId(insertedId);
            return UrgencyNew;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Urgency> findAllUrgencies() {
        String sql = "select id, name, description, start_date, end_date, st_y(st_astext(location)) AS latitude, st_x(st_astext(location)) AS longitude, id_coordinator, delete  from urgency where delete = false";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql).executeAndFetch(Urgency.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Urgency> findUrgencyById(Long id) {
        String sql = "select id, name, description, start_date, end_date, st_y(st_astext(location)) AS latitude, st_x(st_astext(location)) AS longitude, id_coordinator, delete from urgency where urgency.id = :id and delete=false";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("id", id).executeAndFetch(Urgency.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Urgency updateUrgency(Urgency UrgencyNew, Long idUrgency) {
        try (Connection conn = sql2o.open()) {
            String location = "POINT("+UrgencyNew.getLongitude()+" "+UrgencyNew.getLatitude()+", 4326)";
            String sql = "UPDATE urgency SET name = :name, description = :description, location = :location, id_coordinator = :id_coordinator, delete = :delete WHERE id = :id and delete=false";
            conn.createQuery(sql, true)
                    .addParameter("id", UrgencyNew.getId())
                    .addParameter("name", UrgencyNew.getName())
                    .addParameter("description", UrgencyNew.getDescription())
                    .addParameter("location", location)
                    .addParameter("id_coordinator", UrgencyNew.getId_coordinator())
                    .addParameter("delete", UrgencyNew.getDelete())
                    .executeUpdate();
            return UrgencyNew;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteUrgency(Long id) {
        try (Connection con = sql2o.open()) {
            id = (Long) con.createQuery("UPDATE urgency SET delete = true WHERE id = :id and delete=false", true)
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
            lastId = Long.parseLong(String
                    .valueOf(conn.createQuery("select max(urgency.id) from urgency", true).executeScalar(long.class)));
            return lastId;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }
}
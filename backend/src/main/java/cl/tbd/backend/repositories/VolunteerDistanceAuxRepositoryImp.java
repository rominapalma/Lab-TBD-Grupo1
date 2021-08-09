package cl.tbd.backend.repositories;

import cl.tbd.backend.models.VolunteerDistanceAux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class VolunteerDistanceAuxRepositoryImp implements VolunteerDistanceAuxRepository {
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<VolunteerDistanceAux> volunteerDistance(double latitude, double longitude, long number) {
        String location = "POINT(" + longitude + " " + latitude + ")";
        String sql = "select volunteer.name as name, st_distance(ST_GeomFromText('" + location + "', 4326), volunteer.location::geography) AS distance, st_y(st_astext(volunteer.location)) AS latitude, st_x(st_astext(volunteer.location)) AS longitude from volunteer order by id asc limit :number";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .addParameter("number", number)
                    .executeAndFetch(VolunteerDistanceAux.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

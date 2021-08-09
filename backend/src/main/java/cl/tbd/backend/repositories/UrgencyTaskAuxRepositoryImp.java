package cl.tbd.backend.repositories;

import cl.tbd.backend.models.UrgencyTaskAux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UrgencyTaskAuxRepositoryImp implements UrgencyTaskAuxRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<UrgencyTaskAux> viewDetailsUrgencyById(Long id) {
        String sqlPropuesta = "select urgency.id              as id,\n" +
                "       task.num_vol_req        as num_vol_req,\n" +
                "       count(urgency.id)              as num_vol_signin,\n" +
                "       urgency.start_date      as start_date,\n" +
                "       urgency.end_date        as end_date,\n" +
                "       urgency.name            as name,\n" +
                "       urgency.description     as description,\n" +
                "       status_task.description as status,\n" +
                "       urgency.id_coordinator  as status,\n" +
                "       urgency.delete          as delete\n" +
                "from task\n" +
                "         join urgency on urgency.id = task.id_urgency\n" +
                "         join status_task on task.id_status_task = status_task.id\n" +
                "         join ranking on ranking.id_task = task.id\n" +
                "where urgency.id = :id\n" +
                "  and urgency.delete = false\n" +
                "  and status_task.delete = false\n" +
                "  and task.start_date is not null\n" +
                "  and task.end_date is not null\n" +
                "  and urgency.start_date is not null\n" +
                "  and urgency.end_date is not null\n" +
                "group by urgency.id, task.num_vol_req, urgency.start_date, urgency.end_date, urgency.name,\n" +
                "         urgency.description, status_task.description, urgency.id_coordinator, urgency.delete";

        String sql = "select t.num_vol_req, t.num_vol_signin, u.id as id, u.start_date as start_date, u.end_date as end_date, u.description as description, u.name as name, st.description as status, u.id_coordinator as id_coordinator, u.delete as delete from task as t join urgency u on u.id = t.id_urgency join status_task st on t.id_status_task = st.id where u.id = :id and u.delete = false";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sqlPropuesta, true)
                    .addParameter("id", id)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(UrgencyTaskAux.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}

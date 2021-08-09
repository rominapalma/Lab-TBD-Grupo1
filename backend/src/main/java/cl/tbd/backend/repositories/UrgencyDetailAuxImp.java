package cl.tbd.backend.repositories;

import cl.tbd.backend.models.UrgencyDetailAux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class UrgencyDetailAuxImp implements UrgencyDetailAuxRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public UrgencyDetailAux createUrgencyDetailAux(UrgencyDetailAux UrgencyDetailAuxNew) {
        return null;
    }

    @Override
    public List<UrgencyDetailAux> findAllUrgencyDetailAux() {
        String sqlPropuesta = "select urgency.id                           as id,\n" +
                "       max(urgency.name)                    as name,\n" +
                "       max(urgency.description)             as description,\n" +
                "       max(urgency.start_date)              as start_date,\n" +
                "       max(urgency.end_date)                as end_date,\n" +
                "       max(st_y(st_astext(location)))       as latitude,\n" +
                "       max(st_x(st_astext(location)))       as longitude,\n" +
                "       count(task.id)                       as tasks,\n" +
                "       count(distinct ranking.id_volunteer) as volunteers\n" +
                "from status_task\n" +
                "         join task on status_task.id = task.id_status_task\n" +
                "         join urgency on urgency.id = task.id_urgency\n" +
                "         join ranking on ranking.id_task = task.id\n" +
                "where status_task.id = 1\n" +
                "  and status_task.delete = false\n" +
                "  and task.start_date is not null\n" +
                "  and task.end_date is not null\n" +
                "  and urgency.start_date is not null\n" +
                "  and urgency.end_date is not null\n" +
                "  and urgency.end_date < CURRENT_DATE\n" +
                "group by urgency.id\n" +
                "order by urgency.id";
        String sql = "select urgency.id as id, max(urgency.name) as name, max(urgency.description) as description, max(urgency.start_date) as start_date, max(urgency.end_date) as end_date, max(st_y(st_astext(location))) as latitude, max(st_x(st_astext(location))) as longitude, count(distinct task.id) as tasks, count(distinct ranking.id_volunteer) as volunteers from urgency join task on task.id_urgency = urgency.id join ranking on ranking.id_task = task.id where urgency.end_date is not NULL and urgency.delete = false group by urgency.id";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sqlPropuesta).
                    executeAndFetch(UrgencyDetailAux.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<UrgencyDetailAux> findUrgencyDetailAuxById(Long id) {
        return null;
    }

    @Override
    public UrgencyDetailAux updateUrgencyDetailAux(UrgencyDetailAux UrgencyDetailAuxNew, Long idUrgencyDetailAux) {
        return null;
    }

    @Override
    public Boolean deleteUrgencyDetailAux(Long id) {
        return null;
    }
}

package cl.tbd.backend.repositories;

import cl.tbd.backend.models.SkillByVolunteerAuxDistribuido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class SkillByVolunteerAuxDistribuidoRepositoryImp implements SkillByVolunteerAuxDistribuidoRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public List<SkillByVolunteerAuxDistribuido> skillByVolunteer(){
        String sql = "SELECT volunteer0.name as name_volunteer, volunteer0.origin as origin_volunteer, skill.name as name_skill,  volunteer_skill0.origin as origin_skill\n" +
                "from volunteer0\n" +
                "join volunteer_skill0 on volunteer_skill0.id_volunteer = volunteer0.id\n" +
                "join skill on skill.id = volunteer_skill0.id_skill \n" +
                "group by skill.name, volunteer0.name, volunteer0.origin, volunteer_skill0.origin\n" +
                "UNION ALL\n" +
                "SELECT volunteer1.name as name_volunteer, volunteer1.origin as origin_volunteer, skill.name as name_skill,  volunteer_skill1.origin as origin_skill\n" +
                "from volunteer1\n" +
                "join volunteer_skill1 on volunteer_skill1.id_volunteer = volunteer1.id\n" +
                "join skill on skill.id = volunteer_skill1.id_skill \n" +
                "group by skill.name, volunteer1.name, volunteer1.origin, volunteer_skill1.origin\n" +
                "UNION ALL\n" +
                "SELECT volunteer2.name as name_volunteer, volunteer2.origin as origin_volunteer, skill.name as name_skill,  volunteer_skill2.origin as origen_skill\n" +
                "from volunteer2\n" +
                "join volunteer_skill2 on volunteer_skill2.id_volunteer = volunteer2.id\n" +
                "join skill on skill.id = volunteer_skill2.id_skill \n" +
                "group by skill.name, volunteer2.name, volunteer2.origin, volunteer_skill2.origin";
        try (Connection conn = sql2o.open()) {
            return conn.createQuery(sql)
                    .executeAndFetch(SkillByVolunteerAuxDistribuido.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}

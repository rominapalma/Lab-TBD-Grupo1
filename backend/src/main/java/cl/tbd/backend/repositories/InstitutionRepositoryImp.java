package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class InstitutionRepositoryImp implements InstitutionRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Institution createInstitution(Institution InstitutionNew) {
        Long idNew = lastId() + 1;
        
        try(Connection conn = sql2o.open()){
            String location = "POINT("+InstitutionNew.getLongitude()+" "+InstitutionNew.getLatitude()+")";
            String sql = "INSERT INTO institution (id, name, location, delete) values (:id, :name,  ST_GeomFromText(:location, 4326), :delete)";
            Long insertedId =  conn.createQuery(sql, true)
                    .addParameter("id", idNew)
                    .addParameter("name", InstitutionNew.getName())
                    .addParameter("location", location)
                    .addParameter("delete", InstitutionNew.getDelete())
                    .executeUpdate().getKey(Long.class);
            InstitutionNew.setId(insertedId);
            InstitutionNew.setDelete(false);
            return InstitutionNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Institution> findAllInstitutions() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select id, name, st_y(st_astext(location)) AS latitude, st_x(st_astext(location)) AS longitude, delete from institution where delete = false")
                    .executeAndFetch(Institution.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Institution> findInstitutionById(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select id, name, st_y(st_astext(location)) AS latitude, st_x(st_astext(location)) AS longitude, delete from institution where institution.id = :id and delete=false")
                    .addParameter("id", id)
                    .executeAndFetch(Institution.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Institution updateInstitution(Institution InstitutionNew, Long idInstitution) {
        try(Connection conn = sql2o.open()){
            String location = "POINT("+InstitutionNew.getLongitude()+" "+InstitutionNew.getLatitude()+")";
            String sql = "UPDATE institution SET name = :name, location = :location, delete = :delete WHERE id = :id and delete=false";
            conn.createQuery(sql, true)
                    .addParameter("id",InstitutionNew.getId())
                    .addParameter("name",InstitutionNew.getName())
                    .addParameter("location", location)
                    .addParameter("delete", InstitutionNew.getDelete())
                    .executeUpdate();
            InstitutionNew.setDelete(false);
            return InstitutionNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteInstitution(Long id) {
        try(Connection con = sql2o.open()) {
            id = (Long) con.createQuery("UPDATE institution SET delete = true WHERE id = :id and delete=false",true)
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
            lastId = Long.parseLong(String.valueOf(conn.createQuery("select max(institution.id) from institution", true)
                    .executeScalar(long.class)));
            return lastId;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }
}

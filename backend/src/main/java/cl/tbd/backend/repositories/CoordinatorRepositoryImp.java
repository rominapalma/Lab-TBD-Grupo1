package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Coordinator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class CoordinatorRepositoryImp implements CoordinatorRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Coordinator createCoordinator(Coordinator CoordinatorNew) {
        Long idNew = lastId() + 1;

        try(Connection conn = sql2o.open()){
            String location = "POINT("+CoordinatorNew.getLongitude()+" "+CoordinatorNew.getLatitude()+")";
            String sql = "INSERT INTO coordinator (id,name, id_institution, location, delete) values (:id,:name, :id_institution, ST_GeomFromText(:location, 4326), :delete)";
            Long insertedId =  conn.createQuery(sql, true)
                    .addParameter("id", idNew)
                    .addParameter("name", CoordinatorNew.getName())
                    .addParameter("id_institution", CoordinatorNew.getId_institution())
                    .addParameter("location",location)
                    .addParameter("delete", CoordinatorNew.getDelete())
                    .executeUpdate().getKey(Long.class);
            CoordinatorNew.setId(insertedId);
            CoordinatorNew.setDelete(false);
            return CoordinatorNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Coordinator> findAllCoordinators() {
        try(Connection conn = sql2o.open()){
            String sql = "select id, name, id_institution, st_y(st_astext(location)) AS latitude, st_x(st_astext(location)) AS longitude, delete from coordinator where delete = false";
            return conn.createQuery(sql)
                    .executeAndFetch(Coordinator.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Coordinator> findCoordinatorById(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select id, name, id_institution, st_y(st_astext(location)) AS latitude, st_x(st_astext(location)) AS longitude, delete from coordinator where coordinator.id = :id and delete=false")
                    .addParameter("id", id)
                    .executeAndFetch(Coordinator.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Coordinator updateCoordinator(Coordinator CoordinatorNew, Long idCoordinator) {
        try(Connection conn = sql2o.open()){
            String location = "POINT("+CoordinatorNew.getLongitude()+" "+CoordinatorNew.getLatitude()+")";
            String sql = "UPDATE coordinator SET id = :id, name = :name, id_institution = :id_institution, location = ST_GeomFromText(:location,4326), delete = :delete WHERE id = :id and delete=false";
            conn.createQuery(sql, true)
                    .addParameter("id", idCoordinator)
                    .addParameter("name",CoordinatorNew.getName())
                    .addParameter("id_institution", CoordinatorNew.getId_institution())
                    .addParameter("location", location)
                    .addParameter("delete", CoordinatorNew.getDelete())
                    .executeUpdate();
            CoordinatorNew.setDelete(false);
            return CoordinatorNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteCoordinator(Long id) {
        try(Connection con = sql2o.open()) {
            id = (Long) con.createQuery("UPDATE coordinator SET delete = true WHERE id = :id and delete=false",true)
                    .addParameter("id",id)
                    .executeUpdate().getKey();
            return (id!=null);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return id==null;
        }
    }

    @Override
    public List<Coordinator> findCoordinatorByInstitution(Long id) {
        try(Connection conn = sql2o.open()) {
            String sql = "select id, name, st_y(st_astext(location)) AS latitude, st_x(st_astext(location)) AS longitude from coordinator where id_institution = :id";
            return conn.createQuery(sql)
                    .addParameter("id", id)
                    .executeAndFetch(Coordinator.class);
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Long lastId(){
        Long lastId;
        try(Connection conn = sql2o.open()){
            lastId = Long.parseLong(String.valueOf(conn.createQuery("select max(coordinator.id) from coordinator", true)
                    .executeScalar(long.class)));
            return lastId;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }


}

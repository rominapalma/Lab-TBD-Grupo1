package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Ranking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepositoryImp implements RankingRepository{
    @Autowired
    private Sql2o sql2o;

    @Override
    public Ranking createRanking(Ranking RankingNew) {
        Long idNew = lastId() + 1;
        try(Connection conn = sql2o.open()){
            Long insertedId =  conn.createQuery("INSERT INTO ranking (id,score, flag_guest, flag_participate, id_volunteer, id_task, delete) values (:id,:score, :flag_guest, :flag_participate, :id_volunteer, :id_task, :delete)", true)
                    .addParameter("id", idNew)
                    .addParameter("score", RankingNew.getScore())
                    .addParameter("flag_guest", RankingNew.getFlag_guest())
                    .addParameter("flag_participate", RankingNew.getFlag_participate())
                    .addParameter("id_volunteer", RankingNew.getId_volunteer())
                    .addParameter("id_task", RankingNew.getId_task())
                    .addParameter("delete", RankingNew.getDelete())
                    .executeUpdate().getKey(Long.class);
            RankingNew.setId(insertedId);
            RankingNew.setDelete(false);
            return RankingNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Ranking> findAllRankings() {
        try(Connection conn = sql2o.open()){
            return conn.createQuery("select id,score, flag_guest, flag_participate, id_volunteer, id_task, delete from ranking where delete = false")
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Ranking> findRankingById(Long id) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select id,score, flag_guest, flag_participate, id_volunteer, id_task, delete from ranking where ranking.id = :id and delete=false")
                    .addParameter("id", id)
                    .executeAndFetch(Ranking.class);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Ranking updateRanking(Ranking RankingNew, Long idRanking) {
        try(Connection conn = sql2o.open()){
            conn.createQuery("UPDATE ranking SET score = :score, flag_guest = :flag_guest, flag_participate = :flag_participate, id_volunteer = :id_volunteer, id_task = :id_task, delete = :delete WHERE id = :id and delete=false", true)
                    .addParameter("score", RankingNew.getScore())
                    .addParameter("flag_guest", RankingNew.getFlag_guest())
                    .addParameter("flag_participate", RankingNew.getFlag_participate())
                    .addParameter("id_volunteer", RankingNew.getId_volunteer())
                    .addParameter("id_task", RankingNew.getId_task())
                    .addParameter("delete", RankingNew.getDelete())
                    .executeUpdate();
            return RankingNew;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Boolean deleteRanking(Long id) {
        try(Connection con = sql2o.open()) {
            id = (Long) con.createQuery("UPDATE ranking SET delete = true WHERE id = :id and delete=false",true)
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
            lastId = Long.parseLong(String.valueOf(conn.createQuery("select max(ranking.id) from ranking", true)
                    .executeScalar(long.class)));
            return lastId;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return Long.valueOf(0);
        }
    }
}

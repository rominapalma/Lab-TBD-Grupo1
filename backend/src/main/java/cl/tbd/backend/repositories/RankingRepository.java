package cl.tbd.backend.repositories;

import cl.tbd.backend.models.Ranking;

import java.util.List;

public interface RankingRepository {
    public Ranking createRanking(Ranking RankingNew);
    public List<Ranking> findAllRankings();
    public List<Ranking> findRankingById(Long id);
    public Ranking updateRanking(Ranking RankingNew, Long idRanking);
    public Boolean deleteRanking(Long id);
}
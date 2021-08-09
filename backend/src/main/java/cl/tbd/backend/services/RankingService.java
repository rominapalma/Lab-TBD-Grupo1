package cl.tbd.backend.services;

import cl.tbd.backend.models.Ranking;
import cl.tbd.backend.repositories.RankingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class RankingService {
    private final RankingRepository rankingRepository;

    public RankingService(RankingRepository rankingRepository) {
        this.rankingRepository = rankingRepository;
    }

    @PostMapping("/ranking/")
    public Ranking createRanking(@RequestBody Ranking rankingNew){
        return rankingRepository.createRanking(rankingNew);
    }

    @PutMapping("/ranking/{id}/")
    @ResponseBody
    public Ranking updateRanking(Ranking rankingNew){
        return rankingRepository.updateRanking(rankingNew, rankingNew.getId());
    }

    @GetMapping("/allRankings")
    public List<Ranking> findAllRankings() {
        return rankingRepository.findAllRankings();
    }
    @GetMapping("/ranking/{id}")
    public List<Ranking> findRankingById(@PathVariable Long id) {
        return rankingRepository.findRankingById(id);
    }

    @DeleteMapping("/ranking/{id}")
    public boolean deleteRanking(@PathVariable Long id){
        return rankingRepository.deleteRanking(id);
    }
}



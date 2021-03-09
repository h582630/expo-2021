package expo2021.prosjektexpo2021.v2.service;

import expo2021.prosjektexpo2021.v2.dao.StandRepository;
import expo2021.prosjektexpo2021.v2.models.Stand;
import expo2021.prosjektexpo2021.v2.models.Vote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StandService {

    private final StandRepository standRepository;

    @Autowired
    public StandService(@Qualifier("postgres") StandRepository standRepository){
        this.standRepository = standRepository;
    }

    public void addStand(Stand stand){
        standRepository.save(stand);

    }

    public List<Stand> getStands(){
        var stands = new ArrayList<Stand>();

        standRepository.findAll().forEach(stands::add);

        return stands;

    }

    public void deleteById(int id){
        standRepository.deleteById(id);
    }

    public Stand findById(int id){
          return standRepository.findById(id).get();

    }

    public List<Vote> getVotesToStandById(int id){
        return standRepository.findById(id).get().getVotes();

    }

    public double averageVote(int id){
        var votes = getVotesToStandById(id);

        return votes.stream()
                .mapToDouble(Vote::getValue)
                .average()
                .orElse(Double.NaN);
    }

    public void addVoteToStand(Stand stand, Vote vote){
        stand.addVote(vote);
        standRepository.save(stand);
    }
}

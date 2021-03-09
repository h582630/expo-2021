package expo2021.prosjektexpo2021.v2.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
public class Stand {
    @Id
    private int id;
    private String name;

    private double averageVote;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    List<Vote> votes;



    public Stand(int id, String name){
        this.id = id;
        this.name = name;
    }

    public Stand() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void addVote(Vote vote){
        this.votes.add(vote);
    }

    public List<Vote> getVotes() {
        return votes;
    }

    public void setVotes(List<Vote> votes) {
        this.votes = votes;
    }

    public double getAverageVote() {
        return averageVote;
    }

    public void setAverageVote(double averageVote) {
        this.averageVote = averageVote;
    }

    public double averageVote(){

        return votes.stream()
                .mapToDouble(Vote::getValue)
                .average()
                .orElse(Double.NaN);
    }
}

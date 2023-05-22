package kea.dilemmaspilbackend.dilemmas.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Statistics implements Comparable<Statistics>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int statId;

    @OneToOne
    @JoinColumn(name = "packageId", referencedColumnName = "id")
    private CardPackageModel cardPackageModel;

    private int timesPlayed;




    public void incrementTimesPlayed(){
        this.timesPlayed++;
    }

    @Override
    public int compareTo(Statistics o) {
        return timesPlayed - o.timesPlayed;
    }
}

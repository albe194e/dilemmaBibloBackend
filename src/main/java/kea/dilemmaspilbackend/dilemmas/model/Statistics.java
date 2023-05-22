package kea.dilemmaspilbackend.dilemmas.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Statistics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "packageId", referencedColumnName = "id")
    private CardPackageModel cardPackageModel;

    private int timesPlayed;



    public void incrementTimesPlayed(){
        this.timesPlayed++;
    }

}

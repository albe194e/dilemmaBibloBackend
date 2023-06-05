package kea.dilemmaspilbackend.dilemmas.controller;

import kea.dilemmaspilbackend.dilemmas.model.CardPackageModel;
import kea.dilemmaspilbackend.dilemmas.model.DilemmaModel;
import kea.dilemmaspilbackend.dilemmas.model.Statistics;
import kea.dilemmaspilbackend.dilemmas.repository.CardPackageRepository;
import kea.dilemmaspilbackend.dilemmas.repository.DilemmaRepository;
import kea.dilemmaspilbackend.dilemmas.repository.StatisticsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest

class StatisticsControllerTest {



    @Autowired
    CardPackageRepository cardPackageRepository;
    @Autowired
    DilemmaRepository dilemmaRepository;
    @Autowired
    StatisticsRepository statisticsRepository;

    @BeforeEach
    void setUp() {

        CardPackageModel cardPackageModel = new CardPackageModel();

        DilemmaModel dilemmaModel = new DilemmaModel();



        dilemmaModel.setEnName("test");
        dilemmaModel.setDaName("test");


        cardPackageModel.setDaName("test");
        cardPackageModel.setEnName("test");

        cardPackageModel.addDilemma(dilemmaModel);
        dilemmaModel.addCardPackage(cardPackageModel);

        cardPackageRepository.save(cardPackageModel);
        dilemmaRepository.save(dilemmaModel);

        Statistics packageStats = new Statistics();
        packageStats.setCardPackageModel(cardPackageModel);
        packageStats.setTimesPlayed(0);

        statisticsRepository.save(packageStats);


    }

    @Test
    void updateStat() {

        Statistics stat = statisticsRepository.findAll().iterator().next();

        stat.incrementTimesPlayed();
        statisticsRepository.save(stat);

        assertEquals(1, statisticsRepository.findAll().iterator().next().getTimesPlayed());

    }

    @Test
    void getAllByPopularity() {

        //Create a different cardpackage
        CardPackageModel cardPackageModel = new CardPackageModel();
        cardPackageModel.setDaName("test");
        cardPackageModel.setEnName("test");
        cardPackageRepository.save(cardPackageModel);

        //Create a new stat with 0, so that there are 2 stats, 1 with 0 and 1 with 1
        Statistics newStat = new Statistics();
        newStat.setCardPackageModel(cardPackageModel);
        newStat.setTimesPlayed(0);

        statisticsRepository.save(newStat);

        //Update 1 of the stats, so that it has 1 times played
        Statistics stat = statisticsRepository.findAll().iterator().next();

        stat.incrementTimesPlayed();
        statisticsRepository.save(stat);


        Set<Statistics> stats = statisticsRepository.getAllByOrderByTimesPlayedDesc();

        List<Statistics> statsList = List.copyOf(stats);

        //Check that the first stat has 1 times played, the second has 0
        assertEquals(1, statsList.get(0).getTimesPlayed());
        assertEquals(0, statsList.get(1).getTimesPlayed());


    }
}
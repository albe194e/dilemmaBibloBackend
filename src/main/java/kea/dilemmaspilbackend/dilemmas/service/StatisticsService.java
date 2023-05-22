package kea.dilemmaspilbackend.dilemmas.service;

import kea.dilemmaspilbackend.dilemmas.model.Statistics;
import kea.dilemmaspilbackend.dilemmas.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;



    public void createStatistics(Statistics stat){

        statisticsRepository.save(stat);

    }

    public void incrementTimesPlayed(Statistics stat){


        stat.incrementTimesPlayed();
        statisticsRepository.save(stat);

    }

    public Statistics getStatisticsById(Integer id){
        return statisticsRepository.findById(id).get();
    }

    public Set<Statistics> getAllByPopularity() {

        return statisticsRepository.getAllByOrderByTimesPlayedDesc();
    }
}

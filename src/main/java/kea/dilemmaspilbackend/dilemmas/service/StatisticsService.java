package kea.dilemmaspilbackend.dilemmas.service;

import kea.dilemmaspilbackend.dilemmas.model.Statistics;
import kea.dilemmaspilbackend.dilemmas.repository.StatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsService {

    @Autowired
    private StatisticsRepository statisticsRepository;

    public List<Statistics> getAllTimesPlayedDesc(){

        List<Statistics> stats = statisticsRepository.getAllByOrderByTimesPlayedDesc();

        System.out.println("List with stats" + stats);
        return stats;
    }

    public void createStatistics(Statistics stat){

        statisticsRepository.save(stat);

    }

    public void incrementTimesPlayed(Statistics stat){


        stat.setTimesPlayed(stat.getTimesPlayed() + 1);
        statisticsRepository.save(stat);

    }

    public Statistics getStatisticsById(Integer id){
        return statisticsRepository.findById(Long.valueOf(id)).get();
    }

}

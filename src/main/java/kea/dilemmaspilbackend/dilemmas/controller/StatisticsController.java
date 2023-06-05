package kea.dilemmaspilbackend.dilemmas.controller;

import kea.dilemmaspilbackend.dilemmas.model.Statistics;
import kea.dilemmaspilbackend.dilemmas.service.StatisticsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
@CrossOrigin
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;


    @PutMapping("api/put/{id}/statistics/{stat}")
    public void updateStat(@PathVariable Integer id, @PathVariable String stat){

        System.out.println("id: " + id + " stat: " + stat);

        Statistics statistics = statisticsService.getStatisticsById(id);

        switch (stat){
            case "timesPlayed":
                statisticsService.incrementTimesPlayed(statistics);
                break;
        }

    }

    @GetMapping("api/get/findAll")
    public ResponseEntity<Set<Statistics>> getAllByPopularity(){

        Set<Statistics> stats = statisticsService.getAllByPopularity();

        return ResponseEntity.ok(stats);
    }
}
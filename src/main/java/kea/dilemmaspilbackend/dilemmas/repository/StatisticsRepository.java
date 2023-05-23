package kea.dilemmaspilbackend.dilemmas.repository;

import kea.dilemmaspilbackend.dilemmas.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface StatisticsRepository extends JpaRepository<Statistics,Integer>{



    Set<Statistics> getAllByOrderByTimesPlayedDesc();
}
package kea.dilemmaspilbackend.admin.repository;


import kea.dilemmaspilbackend.admin.model.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SuggestionRepository extends JpaRepository<Suggestion,Integer> {
}

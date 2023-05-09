package kea.dilemmaspilbackend.dilemmas.repository;

import kea.dilemmaspilbackend.dilemmas.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
}

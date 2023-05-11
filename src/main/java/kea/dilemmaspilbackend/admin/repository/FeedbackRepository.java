package kea.dilemmaspilbackend.admin.repository;

import kea.dilemmaspilbackend.admin.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
}

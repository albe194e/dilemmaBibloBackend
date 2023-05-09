package kea.dilemmaspilbackend.dilemmas.controller;

import kea.dilemmaspilbackend.dilemmas.model.Feedback;
import kea.dilemmaspilbackend.dilemmas.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class FeedbackController {


    @Autowired
    FeedbackRepository feedbackRepository;


    @PostMapping("/api/post/feedback")
    public void createFeedback(@RequestBody Feedback feedback){


        feedbackRepository.save(feedback);
    }

}

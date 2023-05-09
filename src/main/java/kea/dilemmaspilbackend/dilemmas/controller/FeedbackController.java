package kea.dilemmaspilbackend.dilemmas.controller;

import kea.dilemmaspilbackend.dilemmas.model.Feedback;
import kea.dilemmaspilbackend.dilemmas.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FeedbackController {


    @Autowired
    FeedbackRepository feedbackRepository;


    @GetMapping("/api/get/feedback")
    public Iterable<Feedback> getFeedback(){

        return feedbackRepository.findAll();
    }

    @PostMapping("/api/post/feedback")
    public void createFeedback(@RequestBody Feedback feedback){


        feedbackRepository.save(feedback);
    }

}

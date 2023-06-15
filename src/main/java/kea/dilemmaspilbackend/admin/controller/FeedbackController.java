package kea.dilemmaspilbackend.admin.controller;

import kea.dilemmaspilbackend.admin.model.Feedback;
import kea.dilemmaspilbackend.admin.model.Suggestion;
import kea.dilemmaspilbackend.admin.repository.FeedbackRepository;
import kea.dilemmaspilbackend.admin.repository.SuggestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class FeedbackController {


    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    SuggestionRepository suggestionRepository;


    @GetMapping("/api/get/feedback")
    public Iterable<Feedback> getFeedback(){

        return feedbackRepository.findAll();
    }

    @GetMapping("/api/get/suggestion")
    public Iterable<Suggestion> getSuggestions(){

        return suggestionRepository.findAll();
    }

    @GetMapping("/api/get/findAll/suggestion")
    public Iterable<Suggestion> getSuggestion(){



        return suggestionRepository.findAll();
    }
    @PostMapping("/api/post/suggestion")
    public void createSuggestion(@RequestBody Suggestion suggestion){

            suggestionRepository.save(suggestion);
    }


    @PostMapping("/api/post/feedback")
    public void createFeedback(@RequestBody Feedback feedback){


        feedbackRepository.save(feedback);
    }

}

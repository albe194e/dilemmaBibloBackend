package kea.dilemmaspilbackend.admin.controller;

import kea.dilemmaspilbackend.admin.model.Feedback;
import kea.dilemmaspilbackend.admin.model.Suggestion;
import kea.dilemmaspilbackend.admin.repository.FeedbackRepository;
import kea.dilemmaspilbackend.admin.repository.SuggestionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FeedbackControllerTest {


    @Autowired
    FeedbackRepository feedbackRepository;
    @Autowired
    SuggestionRepository suggestionRepository;

    @BeforeEach
    void createSuggestion() {

        Suggestion suggestion = new Suggestion();
        suggestion.setData("test");
        suggestionRepository.save(suggestion);

    }

    @BeforeEach
    void createFeedback() {

        Feedback feedback = new Feedback();
        feedback.setFeedback("test");
        feedbackRepository.save(feedback);

    }

    @Test
    void feedBackSaved() {

        Iterable<Feedback> feedback = feedbackRepository.findAll();
        assertTrue(feedback.iterator().hasNext());

    }

    @Test
    void suggestionSaved() {

        Iterable<Suggestion> suggestion = suggestionRepository.findAll();
        assertTrue(suggestion.iterator().hasNext());

    }
}
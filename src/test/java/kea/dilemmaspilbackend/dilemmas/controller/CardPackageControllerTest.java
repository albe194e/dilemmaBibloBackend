package kea.dilemmaspilbackend.dilemmas.controller;


import kea.dilemmaspilbackend.dilemmas.model.CardPackageModel;
import kea.dilemmaspilbackend.dilemmas.model.DilemmaModel;
import kea.dilemmaspilbackend.dilemmas.repository.CardPackageRepository;
import kea.dilemmaspilbackend.dilemmas.repository.DilemmaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest

class CardPackageControllerTest {

    @Autowired
    CardPackageRepository cardPackageRepository;
    @Autowired
    DilemmaRepository dilemmaRepository;

    @BeforeEach
    void setUp() {

        CardPackageModel cardPackageModel = new CardPackageModel();

        DilemmaModel dilemmaModel = new DilemmaModel();

        dilemmaModel.setEnName("test");
        dilemmaModel.setDaName("test");


        cardPackageModel.setDaName("test");
        cardPackageModel.setEnName("test");

        cardPackageModel.addDilemma(dilemmaModel);
        dilemmaModel.addCardPackage(cardPackageModel);

        cardPackageRepository.save(cardPackageModel);
        dilemmaRepository.save(dilemmaModel);


    }


    @Test
    void deleteCardpackage() {

        cardPackageRepository.delete(cardPackageRepository.findAll().iterator().next());

        assertFalse(cardPackageRepository.findAll().iterator().hasNext());

    }



    @Test
    void removeDilemma() {

        CardPackageModel cardPackageModel = cardPackageRepository.findAll().iterator().next();

        DilemmaModel dilemmaModel = dilemmaRepository.findAll().iterator().next();

        cardPackageModel.removeDilemma(dilemmaModel);

        cardPackageRepository.save(cardPackageModel);

        assertEquals(cardPackageModel.getDilemmaModels().size(),0);


    }

}
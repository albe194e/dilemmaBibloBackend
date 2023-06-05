package kea.dilemmaspilbackend.game.model;

import kea.dilemmaspilbackend.dilemmas.model.CardPackageModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameLobbyTest {
    GameLobby gameLobby;

    @BeforeEach // kaldes før hver @Test
    public void setUp()  {
        Player player = new Player();
        CardPackageModel cardPackageModel = new CardPackageModel();
        gameLobby = new GameLobby(cardPackageModel, player);
    }

    @Test
    public void testCreateLobbyCode(){



        Assertions.assertEquals(gameLobby.getLobbyCode().length(), 5);
    }
}

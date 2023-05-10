package kea.dilemmaspilbackend.game.service;

import kea.dilemmaspilbackend.dilemmas.model.CardPackageModel;
import kea.dilemmaspilbackend.dilemmas.repository.CardPackageRepository;
import kea.dilemmaspilbackend.dilemmas.repository.DilemmaRepository;
import kea.dilemmaspilbackend.dilemmas.service.CardPackageService;
import kea.dilemmaspilbackend.game.model.GameLobby;
import kea.dilemmaspilbackend.game.model.GameLobbyLogger;
import kea.dilemmaspilbackend.game.model.Player;
import kea.dilemmaspilbackend.game.repository.GameRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static kea.dilemmaspilbackend.game.model.StudyField.DATAMATIKER;

@SpringBootTest
public class GameServiceTest {
    GameService gameService;
    GameRepository gameRepository;
    @Autowired
    CardPackageRepository cardPackageRepository;
    @Autowired
    DilemmaRepository dilemmaRepository;
    @Autowired
    GameLobbyLoggerService gameLobbyLoggerService;
    CardPackageModel cardPackageModel;
    @BeforeEach // kaldes før hver @Test
    public void setUp()  {
        gameRepository = new GameRepository();
        cardPackageModel = new CardPackageModel();
        GameLobbyLogger gameLobbyLogger = new GameLobbyLogger(gameLobbyLoggerService);
        CardPackageService cardPackageService = new CardPackageService(cardPackageRepository, dilemmaRepository);

        gameService = new GameService(gameRepository, cardPackageService, gameLobbyLogger);
    }

    @Test
    public void testCreateGameLobby(){
        // Tests if a lobby is added to the game lobby list by checking if the lobby code works as a key in the list.
        Player player = new Player();

        GameLobby gameLobby = gameService.createGameLobby(player, 1);


        Assertions.assertNotNull(gameLobby);
    }

    @Test
    public void testJoinGameLobby(){
        // Tests a player joining a game lobby. If the player exists in the player list of the lobby, the test is successful
        Player player = new Player();
        player.setName("Thomas");

        GameLobby gameLobby = gameService.createGameLobby(player, 1);
        String lobbyCode = gameLobby.getLobbyCode();


        gameService.joinGameLobby(player, lobbyCode);
        Assertions.assertEquals(gameRepository.getGameLobbyList().get(lobbyCode).getPlayerList().get(0).getName(), player.getName());
    }

    @Test
    public void testRemoveGameLobby(){
        // Tests if a lobby is removed from the list of active games. If the lobby is removed, the test is successful.
        Player player = new Player();
        GameLobby gameLobby = gameService.createGameLobby(player, 1);
        String lobbyCode = gameLobby.getLobbyCode();

        gameService.removeGameLobby(lobbyCode);
        Assertions.assertNull(gameRepository.getGameLobbyList().get(lobbyCode));
    }

    @Test
    public void testLeaveGameLobby(){
        // Tests if a player has left a game lobby. If the player leaves, it's a success
        Player player = new Player();
        player.setName("Thomas");


        GameLobby gameLobby = gameService.createGameLobby(player, 1);
        String lobbyCode = gameLobby.getLobbyCode();

        gameService.leaveGameLobby(player, lobbyCode);
        Assertions.assertTrue(gameRepository.getGameLobbyList().get(lobbyCode).getPlayerList().isEmpty());
    }

    @Test
    public void testReadyUp(){
        // Tests if a player in a lobby has readied up.
        Player player = new Player();
        player.setName("Thomas");

        GameLobby gameLobby = gameService.createGameLobby(player, 1);
        String lobbyCode = gameLobby.getLobbyCode();

        gameService.readyUp(player, lobbyCode);
        Assertions.assertTrue(gameRepository.getGameLobbyList().get(lobbyCode).getPlayerList().get(0).isReady());
    }
    /*
    @Test
    public void testGameLobbySave() {
        Player player = new Player();
        player.setGroupFieldOfStudy(DATAMATIKER);
        player.setName("Thomas");
        GameLobby gameLobby = gameService.createGameLobby(player, 1);
        gameService.endGame(gameLobby.getLobbyCode());
    }

     */
}

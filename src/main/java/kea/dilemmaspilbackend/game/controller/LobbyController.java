package kea.dilemmaspilbackend.game.controller;


import kea.dilemmaspilbackend.game.model.GameLobby;
import kea.dilemmaspilbackend.game.model.Player;
import kea.dilemmaspilbackend.game.model.response.LobbyResponse;
import kea.dilemmaspilbackend.game.service.GameService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin
@AllArgsConstructor
@RestController
public class LobbyController {

    private GameService gameService;

    @PostMapping ("api/post/create/lobby/{cardpackageId}")
    public ResponseEntity<GameLobby> createLobby(@RequestBody Player player, @PathVariable int cardpackageId){

        System.out.println(cardpackageId);

        GameLobby gameLobby = gameService.createGameLobby(player, cardpackageId);

        return new ResponseEntity<>(gameLobby, HttpStatus.OK);
    }


    @GetMapping("api/get/read/lobbyExist/{lobbyID}")
    public ResponseEntity<LobbyResponse> lobbyExist(@PathVariable String lobbyID){
        ResponseEntity<LobbyResponse> message;
        LobbyResponse lobbyResponse = new LobbyResponse();

        // finds game lobby
        GameLobby gameLobby = gameService.fetchGameLobbyFromLobbyCode(lobbyID);

        if (gameService.lobbyExist(lobbyID)){
            lobbyResponse.setGameLobby(gameLobby);
            lobbyResponse.setMessage("Lobby: Found");

            message = new ResponseEntity<>(lobbyResponse, HttpStatus.OK);
        } else {
            lobbyResponse.setGameLobby(null);
            lobbyResponse.setMessage("Lobby: Not Found");

            message = new ResponseEntity<>(lobbyResponse, HttpStatus.OK);
        }

        return message;
    }


    @GetMapping("api/get/all/lobby")
    public ResponseEntity<List<GameLobby>> getAllLobby(){
        List<GameLobby> list = gameService.getAllLobby();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("api/get/read/lobby/{lobbyID}")
    public ResponseEntity<GameLobby> getLobby(@PathVariable String lobbyID){
        GameLobby gameLobby = gameService.fetchGameLobbyFromLobbyCode(lobbyID);
        return new ResponseEntity<>(gameLobby, HttpStatus.OK);
    }


    @PostMapping("api/post/save/lobbyStats")
    public ResponseEntity<HttpStatus> saveStats(@RequestBody GameLobby gameLobby){

        System.out.println(gameLobby.getLobbyCode());

        gameService.endGame(gameLobby);

        return new ResponseEntity<>(HttpStatus.OK);
    }





}

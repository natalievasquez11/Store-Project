package com.company.gamestorecontroller.controllers;

import com.company.gamestorecontroller.dto.Game;
import com.company.gamestorecontroller.service.GameServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
public class GameController {
    @Autowired
    private GameServiceLayer gameService;

    @RequestMapping(value="/games", method= RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.CREATED)
    public Game createGame(@RequestBody @Valid Game game) {
        gameService.addGame(game);
        return game;
    }

    @RequestMapping(value="/games", method= RequestMethod.GET)
    public List<Game> getGames() {
        return gameService.readGame();
    }

    @RequestMapping(value="/game/{id}", method= RequestMethod.GET)
    public Game getOneGame(@PathVariable Integer id) {
        return gameService.readOneGame(id);
    }

    @RequestMapping(value="/game/{id}", method= RequestMethod.PUT)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public Game putGame(@RequestBody @Valid Game game) {
        gameService.updateGame(game);
        return game;
    }

    @RequestMapping(value="/deletegame/{id}", method= RequestMethod.DELETE)
    @ResponseStatus(value= HttpStatus.NO_CONTENT)
    public void delGame(@PathVariable Integer id) {
        gameService.deleteGame(id);
    }

    @RequestMapping(value="/studio/{studio}", method= RequestMethod.GET)
    public List<Game> getStudio(String studio) {
        return gameService.getByStudio(studio);
    }

    @RequestMapping(value="/rating/{rating}", method= RequestMethod.GET)
    public List<Game> getRating(Integer ersbRating) {
        return gameService.getByRating(ersbRating);
    }

    @RequestMapping(value="/title/{title}", method= RequestMethod.GET)
    public List<Game> getTitle(String title) {
        return gameService.getByTitle(title);
    }

}

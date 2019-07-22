package com.company.gamestorecontroller.service;

import com.company.gamestorecontroller.dao.GameRepository;
import com.company.gamestorecontroller.dto.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameServiceLayer {
    @Autowired
    private GameRepository gameRepo;

    public Game addGame(Game game) {
        gameRepo.save(game);
        return game;
    }

    public List<Game> readGame() {
        return gameRepo.findAll();
    }

    public Game readOneGame(Integer id) {
        return gameRepo.getOne(id);
    }

    public Game updateGame(Game game) {
        gameRepo.save(game);
        return game;
    }

    public void deleteGame(Integer id) {
        gameRepo.deleteById(id);
    }

    public List<Game> getByStudio(String studio) {
        return gameRepo.findByStudio(studio);
    }

    public List<Game> getByRating(Integer ersbRating) {
        return gameRepo.findByErsbRating(ersbRating);
    }

    public List<Game> getByTitle(String title) {
        return gameRepo.findByTitle(title);
    }

}

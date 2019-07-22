package com.company.gamestorecontroller.dao;

import com.company.gamestorecontroller.dto.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

    List<Game> findByStudio(String studio);
    List<Game> findByErsbRating(String ersbRating);
    List<Game> findByTitle(String Title);

}

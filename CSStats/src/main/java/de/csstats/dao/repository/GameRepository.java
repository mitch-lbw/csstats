package de.csstats.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.csstats.dao.Game;

public interface GameRepository extends JpaRepository<Game, Integer> {

}

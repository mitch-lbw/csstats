package de.csstats.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.csstats.dao.Player;

public interface PlayerRepository extends JpaRepository<Player, Integer> {

}

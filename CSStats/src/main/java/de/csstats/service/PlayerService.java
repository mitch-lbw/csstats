package de.csstats.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.csstats.dao.Player;
import de.csstats.dao.repository.PlayerRepository;

@Component
public class PlayerService {

	@Autowired
	private PlayerRepository playerRepository;

	public List<Player> getAllPlayers() {
		return playerRepository.findAll();
	}

	public void createDummyPlayer() {
		Player player = new Player();
		player.setPlayerId(1);
		player.setName("DUMMY");
		playerRepository.save(player);
	}
}

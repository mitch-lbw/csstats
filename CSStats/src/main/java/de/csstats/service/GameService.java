package de.csstats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.csstats.dao.repository.GameRepository;

@Component
public class GameService {

	@Autowired
	private GameRepository gameRepository;

	// public List<E>
}

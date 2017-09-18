package de.csstats.ui.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.csstats.dao.Player;
import de.csstats.dao.repository.PlayerRepository;
import de.csstats.service.PlayerService;

@ManagedBean
@RequestScoped
public class OverviewBean {

	@ManagedProperty("#{playerService}")
	private PlayerService playerService;

	@ManagedProperty("#{playerRepository}")
	private PlayerRepository playerRepository;

	private List<Player> allPlayers;

	public static final Logger log = LoggerFactory.getLogger(OverviewBean.class);

	public OverviewBean() {
		log.info("Initializing class " + this.getClass().getName() + " finished");
	}

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

	public List<Player> getAllPlayers() {
		this.playerService.createDummyPlayer();
		if (allPlayers == null) {
			allPlayers = this.playerService.getAllPlayers();
		}
		return allPlayers;
	}

	public void setAllPlayers(List<Player> allPlayers) {
		this.allPlayers = allPlayers;
	}

	public PlayerRepository getPlayerRepository() {
		return playerRepository;
	}

	public void setPlayerRepository(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}

}

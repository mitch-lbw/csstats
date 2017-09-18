package de.csstats.dao;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author donut
 * 
 */
@Entity
@Table(name = "stat_round")
public class Round extends AbstractEntity {

	@Column
	private int roundNum;

	@Column
	private long roundTime;

	@ManyToOne
	@JoinColumn(name = "game_ID")
	private Game game;

	@OneToMany(mappedBy = "round", cascade = CascadeType.ALL)
	private Set<Kill> kills;

	public int getRoundNum() {
		return roundNum;
	}

	public void setRoundNum(int roundNum) {
		this.roundNum = roundNum;
	}

	public long getRoundTime() {
		return roundTime;
	}

	public void setRoundTime(long roundTime) {
		this.roundTime = roundTime;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Set<Kill> getKills() {
		return kills;
	}

	public void setKills(Set<Kill> kills) {
		this.kills = kills;
	}
}

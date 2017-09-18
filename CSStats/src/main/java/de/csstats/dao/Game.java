package de.csstats.dao;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author donut
 * 
 */
@Entity
@Table(name = "stat_game")
public class Game extends AbstractEntity {

	@ManyToOne
	@JoinColumn(name = "map_ID")
	private Map map;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private Set<Round> rounds;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date startTimestamp;

	@Column
	@Temporal(TemporalType.TIMESTAMP)
	private Date endTimestamp;

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public Set<Round> getRounds() {
		return rounds;
	}

	public void setRounds(Set<Round> rounds) {
		this.rounds = rounds;
	}

	public Date getStartTimestamp() {
		return startTimestamp;
	}

	public void setStartTimestamp(Date startTimestamp) {
		this.startTimestamp = startTimestamp;
	}

	public Date getEndTimestamp() {
		return endTimestamp;
	}

	public void setEndTimestamp(Date endTimestamp) {
		this.endTimestamp = endTimestamp;
	}
}

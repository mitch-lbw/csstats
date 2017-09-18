package de.csstats.dao;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Klasse zur Beschreibung eines Spielers muss initialisiert werden !!!
 * 
 * @author donut
 * 
 */
@Entity
@Table(name = "stat_player")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "FRACTION", discriminatorType = DiscriminatorType.STRING, length = 2)
public class Player extends AbstractEntity {

	@Column
	private String name;

	@Column
	private long playerId;

	@Column(name = "FRACTION", insertable = false, updatable = false)
	protected String fraction;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getFraction() {
		return fraction;
	}
}

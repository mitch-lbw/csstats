package de.csstats.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stat_kill")
public class Kill extends AbstractEntity {

	@OneToOne
	@JoinColumn(name = "killerPlayer_ID", nullable = false)
	private Player killer;

	@OneToOne
	@JoinColumn(name = "victimPlayer_ID", nullable = false)
	private Player victim;

	@ManyToOne
	@JoinColumn(name = "round_ID")
	private Round round;

	@OneToOne
	@JoinColumn(name = "weapon_ID", nullable = false)
	private Weapon weapon;

	@Column
	private boolean headshot;

	public Player getKiller() {
		return killer;
	}

	public void setKiller(Player killer) {
		this.killer = killer;
	}

	public Player getVictim() {
		return victim;
	}

	public void setVictim(Player victim) {
		this.victim = victim;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	public boolean isHeadshot() {
		return headshot;
	}

	public void setHeadshot(boolean headshot) {
		this.headshot = headshot;
	}
}

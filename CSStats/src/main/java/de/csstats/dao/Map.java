package de.csstats.dao;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stat_map")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "MAP_TYPE", discriminatorType = DiscriminatorType.STRING, length = 2)
public class Map extends AbstractEntity {

	public static enum MAP_TYPE {
		DE, CS
	}

	@Column
	private String name;

	@OneToMany(mappedBy = "map")
	private Set<Game> games;

	@Column(name = "MAP_TYPE", insertable = false, updatable = false)
	protected String mapType;

	@ManyToMany(targetEntity = Logfile.class)
	private Set<Logfile> logfiles;

	public String getName() {
		return getMapType().toLowerCase() + "_" + name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMapType() {
		return mapType;
	}

	public Set<Game> getGames() {
		return games;
	}

	public void setGames(Set<Game> games) {
		this.games = games;
	}

}

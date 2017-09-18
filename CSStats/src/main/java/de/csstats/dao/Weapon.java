package de.csstats.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.util.StringUtils;

/**
 * enthaelt die Beschreibung einer Waffe
 * 
 * @author donut
 *
 */
@Entity
@Table(name = "stat_weapon")
public class Weapon extends AbstractEntity {

	@Transient
	private String image;

	@Column
	private String name;

	public String getImage() {
		if (!StringUtils.hasText(image)) {
			image = "/gifs/" + name + ".gif";
		}
		return image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

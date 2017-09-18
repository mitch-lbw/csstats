package de.csstats.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import de.csstats.dao.repository.PrePersistListener;

@MappedSuperclass
@EntityListeners(PrePersistListener.class)
public abstract class AbstractEntity {

	public static final String SYSTEM_USER = "SYSTEM";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "T_ID")
	private int id;

	@Column(name = "T_USER_CRE")
	private String userCreated;

	@Column(name = "T_USER_CHG")
	private String userChanged;

	public String getUserCreated() {
		return userCreated;
	}

	public void setUserCreated(String userCreated) {
		this.userCreated = userCreated;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "T_DATE_CRE")
	private Date dateCreated;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "T_DATE_CHG")
	private Date dateChanged;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserChanged() {
		return userChanged;
	}

	public void setUserChanged(String userChanged) {
		this.userChanged = userChanged;
	}

	public Date getDateChanged() {
		return dateChanged;
	}

	public void setDateChanged(Date dateChanged) {
		this.dateChanged = dateChanged;
	}

}

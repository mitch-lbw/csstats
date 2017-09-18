package de.csstats.dao.repository;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import de.csstats.dao.AbstractEntity;

public class PrePersistListener {

	@PrePersist
	public void setCreatedFields(AbstractEntity e) {
		e.setDateCreated(new Date());
		e.setUserCreated(AbstractEntity.SYSTEM_USER);
		setUpdateFields(e);
	}

	@PreUpdate
	public void setUpdateFields(AbstractEntity e) {
		e.setDateChanged(new Date());
		e.setUserChanged(AbstractEntity.SYSTEM_USER);
	}

}

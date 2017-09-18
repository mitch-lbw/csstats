package de.csstats.dao.view;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "v_stat_logorder")
public class Logorder {

	@Id
	@Column(name = "GROUP_KEY")
	public String groupKey;

	@Column(name = "LOG_MAP_FILE")
	public String logMap;

	@Column(name = "LOG_DETAIL_FILE")
	public String logDetail;

	@Column(name = "LOG_BEGIN_TIMESTAMP")
	private Date logBeginTimestamp;

	@Column(name = "LOG_END_TIMESTAMP")
	private Date logEndTimestamp;

	public String getGroupKey() {
		return groupKey;
	}

	public void setGroupKey(String groupKey) {
		this.groupKey = groupKey;
	}

	public String getLogMap() {
		return logMap;
	}

	public void setLogMap(String logMap) {
		this.logMap = logMap;
	}

	public String getLogDetail() {
		return logDetail;
	}

	public void setLogDetail(String logDetail) {
		this.logDetail = logDetail;
	}

	public Date getLogBeginTimestamp() {
		return logBeginTimestamp;
	}

	public void setLogBeginTimestamp(Date logBeginTimestamp) {
		this.logBeginTimestamp = logBeginTimestamp;
	}

	public Date getLogEndTimestamp() {
		return logEndTimestamp;
	}

	public void setLogEndTimestamp(Date logEndTimestamp) {
		this.logEndTimestamp = logEndTimestamp;
	}
}

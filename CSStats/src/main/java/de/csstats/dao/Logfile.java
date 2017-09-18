package de.csstats.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "stat_logfile")
public class Logfile extends AbstractEntity {
	@Column(name = "FILENAME")
	private String filename;

	@Column(name = "HASH")
	private int hash;

	@Column(name = "LOG_BEGIN_TIMESTAMP")
	private Date logBeginTimestamp;

	@Column(name = "LOG_END_TIMESTAMP")
	private Date logEndTimestamp;

	@Column(name = "CONTENT")
	@Lob
	private byte[] content;

	@Column(name = "GROUP_KEY")
	private String groupKey;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getHash() {
		return hash;
	}

	public void setHash(int hash) {
		this.hash = hash;
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

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public String getGroupKey() {
		return groupKey;
	}

	public void setGroupKey(String groupKey) {
		this.groupKey = groupKey;
	}
}

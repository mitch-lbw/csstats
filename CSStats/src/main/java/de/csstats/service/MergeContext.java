package de.csstats.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MergeContext {

	private List<String> correlatingLines;

	private Date latestTimestamp;

	public MergeContext() {
		correlatingLines = new ArrayList<>();
	}

	public List<String> getCorrelatingLines() {
		return correlatingLines;
	}

	public void addLine(String correlatingLine) {

		this.correlatingLines = correlatingLines;
	}

	public Date getLatestTimestamp() {
		return latestTimestamp;
	}

	public void setLatestTimestamp(Date latestTimestamp) {
		this.latestTimestamp = latestTimestamp;
	}

}

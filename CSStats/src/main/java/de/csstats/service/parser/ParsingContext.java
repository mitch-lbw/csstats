package de.csstats.service.parser;

import java.util.Date;

import de.csstats.dao.Map;
import de.csstats.dao.Map.MAP_TYPE;
import de.csstats.dao.MapCS;
import de.csstats.dao.MapDE;

public class ParsingContext {

	private Map currentMap;

	private Date currentTimestamp;

	public void setMap(final String mapName, final MAP_TYPE mapType) {
		switch (mapType) {
		case DE: {
			currentMap = new MapDE();
			break;
		}
		case CS: {
			currentMap = new MapCS();
			break;
		}
		}
		currentMap.setName(mapName);
	}

	public void setCurrentTimestamp(final Date currentTimestamp) {
		this.currentTimestamp = currentTimestamp;
	}

	public Date getCurrentTimestamp() {
		return this.currentTimestamp;
	}

}

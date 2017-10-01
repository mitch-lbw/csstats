package de.csstats.service.parser.impl;

public class ChangedMapParser extends MapParser {

	@Override
	protected String getKeyword() {
		return KEYWORD_LOADED_MAP;
	}

}

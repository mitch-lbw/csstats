package de.csstats.service.parser;

public interface Parser {

	public boolean lineContainsKeyword(final String line);

	public void parse(final ParsingContext context, final String line);

}

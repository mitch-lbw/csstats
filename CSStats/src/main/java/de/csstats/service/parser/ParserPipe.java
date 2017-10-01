package de.csstats.service.parser;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import de.csstats.common.exception.ErrorCode;
import de.csstats.common.exception.ParsingException;
import de.csstats.service.parser.impl.ChangedMapParser;
import de.csstats.service.parser.impl.LoadedMapParser;
import de.csstats.service.parser.impl.TimestampParser;

public class ParserPipe {

	Collection<Parser> parsers = new LinkedList<>();

	private Parser tsParser;

	public ParserPipe() {
		tsParser = new TimestampParser();
		parsers.add(new LoadedMapParser());
		parsers.add(new ChangedMapParser());
	}

	public boolean parse(final ParsingContext context, final String line) throws ParsingException {
		Iterator<Parser> parserIterator = parsers.iterator();
		boolean parseLineSuccess = false;
		if (parseLineSuccess = tsParser.lineContainsKeyword(line)) {
			tsParser.parse(context, line);
		}
		while (parserIterator.hasNext()) {
			Parser currentParser = parserIterator.next();
			if (currentParser.lineContainsKeyword(line)) {
				currentParser.parse(context, line);
				return true;
			}
		}
		if (!parseLineSuccess) {
			throw new ParsingException(ErrorCode.PARSE_EXCEPTION_NON_PARSABLE_LINE, line);
		}
		return parseLineSuccess;
	}
}

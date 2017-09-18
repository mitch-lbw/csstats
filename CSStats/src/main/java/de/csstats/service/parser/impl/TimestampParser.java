package de.csstats.service.parser.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

import de.csstats.common.exception.ErrorCode;
import de.csstats.common.exception.ParsingException;
import de.csstats.service.parser.AbstractParser;
import de.csstats.service.parser.ParsingContext;

public class TimestampParser extends AbstractParser {

	private static DateFormat format = new SimpleDateFormat(TIMESTAMP_FORMAT);

	@Override
	public boolean lineContainsKeyword(String line) {
		if (StringUtils.hasText(line)) {
			return line.matches(VALID_LINE_START + TIMESTAMP_FORMAT.replaceAll("\\w", "[0-9]") + ".*");
		}
		return false;
	}

	@Override
	public void parse(ParsingContext context, String line) {
		if (lineContainsKeyword(line)) {
			try {
				Date currentTimestamp = format
						.parse(line.substring(VALIDATED_LINE_START, TIMESTAMP_FORMAT.length() + VALIDATED_LINE_START));
				context.setCurrentTimestamp(currentTimestamp);
			} catch (Exception e) {
				throw new ParsingException(ErrorCode.PARSE_EXCEPTION_TIMESTAMP, line, e);
			}
		}
	}
}

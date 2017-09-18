package de.csstats.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import de.csstats.common.exception.ParsingException;
import de.csstats.service.parser.ParserPipe;
import de.csstats.service.parser.ParsingContext;

@Service
public class ParserService {

	Logger log = Logger.getLogger(this.getClass());

	private ParserPipe parserPipe;

	public ParserService() {
		parserPipe = new ParserPipe();
	}

	public void parseMapBlock(final ParsingContext context, final String filename) {
		if (StringUtils.hasText(filename)) {
			try (BufferedReader buffStream = new BufferedReader(new FileReader(filename))) {
				String line = buffStream.readLine();
				while (StringUtils.hasText(line) && parserPipe.parse(context, line)) {
					line = buffStream.readLine();
				}
			} catch (IOException | ParsingException e) {
				log.error(e.getMessage(), e);
			}
		}
	}
}

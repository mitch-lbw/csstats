package de.csstats.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import de.csstats.service.parser.impl.TimestampParser;

@Service
public class LogMergerService {

	Logger log = Logger.getLogger(this.getClass());

	private TimestampParser tsParser = new TimestampParser();

	public void mergeLogfiles(final FileInputStream is) {
		if (is != null) {
			try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is))) {
				String line = fileReader.readLine();
				while (StringUtils.hasText(line)) {

				}
			} catch (IOException e) {
				log.error(e.getMessage(), e);
			}
		}
	}

}

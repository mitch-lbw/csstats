package de.csstats.service;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import de.csstats.common.exception.ErrorCode;
import de.csstats.common.exception.ServiceException;
import de.csstats.dao.Logfile;
import de.csstats.dao.repository.LogfileRepository;
import de.csstats.dao.repository.view.LogorderRepository;
import de.csstats.service.parser.Parser;
import de.csstats.service.parser.ParsingContext;
import de.csstats.service.parser.impl.LoadedMapParser;
import de.csstats.service.parser.impl.TimestampParser;

@Service
public class LogfileService {

	Logger log = Logger.getLogger(this.getClass());

	@Autowired
	private LogfileRepository logfileRepository;

	@Autowired
	private LogorderRepository logorderRepository;

	private Parser tsParser;

	private Parser mapParser;

	public LogfileService() {
		tsParser = new TimestampParser();
		mapParser = new LoadedMapParser();
	}

	public boolean uploadFile(final String filename, final byte[] content) throws ServiceException {
		int hash = -1;
		try {
			hash = new String(content, Charset.forName("UTF-8")).hashCode();
		} catch (Exception e) {
			throw new ServiceException(ErrorCode.DATE_RANGE_EXCEPTION, e, filename);
		}
		if (!this.logfileRepository.existsByHash(hash)) {
			Logfile logfile = new Logfile();
			logfile.setContent(content);
			logfile.setFilename(filename);
			logfile.setHash(hash);
			setLogfileDateRange(content, logfile);
			this.logfileRepository.save(logfile);
			return true;
		}
		return false;
	}

	private void setLogfileDateRange(final byte[] content, final Logfile logfile) throws ServiceException {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(content)))) {
			ParsingContext context = new ParsingContext();
			String currentLine = fileReader.readLine();
			String lastline = null;
			while (StringUtils.hasText(currentLine)) {
				if (logfile.getLogBeginTimestamp() == null) {
					tsParser.parse(context, currentLine);
					logfile.setLogBeginTimestamp(context.getCurrentTimestamp());
				}
				if (logfile.getGroupKey() == null && mapParser.lineContainsKeyword(currentLine)) {
					logfile.setGroupKey(java.util.UUID.randomUUID().toString());
				}
				lastline = currentLine;
				currentLine = fileReader.readLine();
			}
			tsParser.parse(context, lastline);
			logfile.setLogEndTimestamp(context.getCurrentTimestamp());

		} catch (IOException e) {
			log.error(e);
			throw new ServiceException(ErrorCode.DATE_RANGE_EXCEPTION, e, logfile.getFilename());
		}
	}

	public void groupLogfiles() {
		List<Logfile> saveInBatch = new ArrayList<>();
		this.logorderRepository.findAll().stream().forEach((logOrder) -> {
			Logfile map = this.logfileRepository.findByFilename(logOrder.getLogMap());
			Logfile detail = this.logfileRepository.findByFilename(logOrder.getLogDetail());
			map.setGroupKey(logOrder.getGroupKey());
			detail.setGroupKey(logOrder.getGroupKey());
			saveInBatch.add(map);
			saveInBatch.add(detail);
		});
		this.logfileRepository.save(saveInBatch);
	}
}

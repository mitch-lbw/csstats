package de.csstats.service.parser;

public abstract class AbstractParser implements Parser {

	protected static final int VALIDATED_LINE_START = 2;

	protected static final String VALID_LINE_START = "L\\s";

	protected static final String OBJECT_DELIMITER = "\"";

	protected static final String KEYWORD_STARTED_MAP = "(.*)(STARTED\\sMAP)(.*)";

	protected static final String KEYWORD_LOADED_MAP = "(.*)(LOADING\\sMAP)(.*)";

	protected static final String TIMESTAMP_FORMAT = "dd/MM/yyyy - HH:mm:ss";

}

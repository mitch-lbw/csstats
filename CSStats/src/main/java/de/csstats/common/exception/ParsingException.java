package de.csstats.common.exception;

public class ParsingException extends BaseException {

	private static final long serialVersionUID = 7863713926675701027L;

	public ParsingException(ErrorCode error, Object... params) {
		super(error, params);
	}

	public ParsingException(ErrorCode error, Throwable exception, Object... params) {
		super(error, exception, params);
	}
}

package de.csstats.common.exception;

public enum ErrorCode {

	PARSE_EXCEPTION_NON_PARSABLE_LINE("line does not contain parsable format %s"),

	PARSE_EXCEPTION_TIMESTAMP("line does not contain parsable timestamp %s"),

	DATE_RANGE_EXCEPTION("date range for file %s cannot be parsed - %s"),

	UPLOAD_FILE_ENCODING_EXCEPTION("error reading content from file %s - %s");

	private String msg;

	private ErrorCode(String msg) {
		this.msg = msg;
	}

	public String getMsg(Object... params) {
		if (params != null) {
			return String.format(msg, params);
		}
		return msg;
	}
}

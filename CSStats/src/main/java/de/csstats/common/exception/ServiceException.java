package de.csstats.common.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -5133237225447370642L;

	public ServiceException(ErrorCode error, Object[] params) {
		super(error.getMsg(params));
	}

	public ServiceException(ErrorCode error, Throwable exception, Object... params) {
		super(error.getMsg(params), exception);
	}

}

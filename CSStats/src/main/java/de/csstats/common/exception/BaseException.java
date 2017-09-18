package de.csstats.common.exception;

public class BaseException extends RuntimeException {

	private static final long serialVersionUID = -9094544473877947004L;

	public BaseException(ErrorCode error, Object... params) {
		super(error.getMsg(params));
	}

	public BaseException(ErrorCode error, Throwable exception, Object... params) {
		super(error.getMsg(params), exception);
	}

}

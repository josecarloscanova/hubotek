package org.hubotek;

@SuppressWarnings("serial")
public class TranformationException extends RuntimeException {

	public TranformationException() {
		super();
	}

	public TranformationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public TranformationException(String message, Throwable cause) {
		super(message, cause);
	}

	public TranformationException(String message) {
		super(message);
	}

	public TranformationException(Throwable cause) {
		super(cause);
	}
	
}

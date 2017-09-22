package it.CarsDB.boot.exceptions;

public class CarsException extends Exception {

	private static final long serialVersionUID = -5014635578923384614L;

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	public CarsException() {
		super();
	}

	public CarsException(String message, Throwable exception) {
		super(message, exception);
	}

	public CarsException(String message) {
		super(message);
	}

	public CarsException(Throwable exception) {
		super(exception);
	}

}

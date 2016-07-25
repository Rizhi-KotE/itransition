package photoapplication.database.service;

public class EmailExistsException extends Exception {

	private static final long serialVersionUID = 2549628104213911286L;

	public EmailExistsException(String message) {
		super(message);
	}
}

package mx.springboot.error.app.customErrors;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException(String id) {
		super("/detalles/".concat(id).concat(" , User not founded in the system."));
	}
	
	

}

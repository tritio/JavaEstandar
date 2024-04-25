package exceptions;

public class ErrorFuenteDatosException extends Exception {

	@Override
	public String getMessage() {
		return "no se ha podido acceder al fichero donde están las notas";
	}
	
}

package br.com.fiap.sonha.exception;

public class UsuarioInexistenteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	public UsuarioInexistenteException(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		return this.message;
	}	
}

package ar.com.educacionit.Dto;

import ar.com.educacionit.connectors.placeholders.dto.UserDTO;

public class ResponsePlaceholderDTO {	
	private String mensaje;
	private UserDTO usuario;
	
	public ResponsePlaceholderDTO(String mensaje, UserDTO usuario) {				
		this.mensaje = mensaje;
		this.usuario = usuario;
	}
		
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public UserDTO getUsuario() {
		return usuario;
	}
	public void setUsuario(UserDTO usuario) {
		this.usuario = usuario;
	}
	
	
}

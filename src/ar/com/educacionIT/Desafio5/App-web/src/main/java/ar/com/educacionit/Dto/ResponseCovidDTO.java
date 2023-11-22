package ar.com.educacionit.Dto;

import ar.com.educacionit.connectors.covid.dto.CovidDTO;

public class ResponseCovidDTO {
	private String mensaje;
	private CovidDTO covid;
	
	public ResponseCovidDTO(String mensaje, CovidDTO covid) {				
		this.mensaje = mensaje;
		this.covid = covid;
	}
		
	public String getMensaje() {
		return mensaje;
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public CovidDTO getCovid() {
		return covid;
	}
	public void setUsuario(CovidDTO covid) {
		this.covid = covid;
	}
	
}

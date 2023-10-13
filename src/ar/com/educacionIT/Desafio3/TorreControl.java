package ar.com.educacionIT.Desafio3;

import java.util.List;

public class TorreControl {
	private List<IVolador> voladores;
	private Operario operario;
	
	public TorreControl(List<IVolador> voladores, Operario operario) {		
		this.voladores = voladores;
		this.operario = operario;
	}
	
	public List<IVolador> getVoladores() {
		return voladores;
	}
	
	public void setVoladores(List<IVolador> voladores) {
		this.voladores = voladores;
	}
	
	public Operario getOperario() {
		return operario;
	}
	
	public void setOperario(Operario operario) {
		this.operario = operario;
	}
	
	public void gestionarAterrizajes() {
		for (IVolador v : voladores) {
			if(v.cumplirContrato()){
				if(v instanceof VoladorAceptado) {
					VoladorAceptado aceptado = ((VoladorAceptado) v); 
					aceptado.aterrizar();
				}	
			}else {
				if(v instanceof VoladorRechazado) {
					VoladorRechazado rechazado = ((VoladorRechazado) v);												
					System.out.println("\nPuede aterrizar "+ rechazado.getEmpresa() +"?");
					boolean autorizacion = operario.autorizarAterrizaje();					
					rechazado.pedirAutorizacion(autorizacion);					
				}
			}
		}
	}	
}

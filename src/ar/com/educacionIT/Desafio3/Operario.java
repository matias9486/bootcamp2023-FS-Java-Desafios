package ar.com.educacionIT.Desafio3;

import java.util.Random;

public class Operario {
	private String nombre;

	public Operario(String nombre) {		
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean autorizarAterrizaje(){
		Random random = new Random();			        			        
		boolean autorizacion = random.nextBoolean();
		System.out.println("Autorizacion aleatorio: " + autorizacion);
		return autorizacion;
	}
}

package ar.com.educacionIT.Desafio3;

import java.util.ArrayList;
import java.util.List;

public class MainDesafio3 {	
	public static void main(String[] args) {
		Operario operario = new Operario("Matias Alancay");
		
		List<IVolador> voladores = new ArrayList<>();
		Volador avion = new VoladorAceptado("Aerolineas Argentina", "Salta");
		Volador avionPrivado = new VoladorRechazado("UFO", "Rosario");
		Volador avionDesconocido = new VoladorRechazado("Aerolineas Escobar CO.", "Medellin");
		
		voladores.add(avion);
		voladores.add(avionPrivado);
		voladores.add(avionDesconocido);
		
		TorreControl torreControl = new TorreControl(voladores, operario);
		torreControl.gestionarAterrizajes();
	}

}

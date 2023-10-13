package ar.com.educacionIT.Desafio2;

import java.util.Arrays;
import java.util.Objects;

public class Alumno {
	private String nombre;
	private String apellido;
	private Double[] notas;
	
	public Alumno(String nombre, String apellido, Double[]notas) {		
		this.nombre = nombre;
		this.apellido = apellido;
		this.notas = notas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Double[] getNotas() {
		return notas;
	}

	public void setNotas(Double[] notas) {
		this.notas = notas;
	}
			
	public double obtenerPromedio() {
		double total = 0;
		int cantidadNotas = notas.length;
		double promedio;
		
		for (Double nota : notas) {
			total+= nota;
		}
		promedio = total/cantidadNotas;
		return promedio;
	}

	@Override
	public String toString() {
		return  apellido + ", "+ nombre +". Notas=" + Arrays.toString(notas) + ". Promedio:"+this.obtenerPromedio();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(notas);
		result = prime * result + Objects.hash(apellido, nombre);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(nombre, other.nombre)
				&& Arrays.equals(notas, other.notas);
	}
	
	
}

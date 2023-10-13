package ar.com.educacionIT.Desafio2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControlNotas {
	private int cantidadAlumnos;
    private Alumno[] alumnos;
    private double promedioMinimo;
    
	public ControlNotas(int cantidadAlumnos, double promedioMinimo) {		
		this.cantidadAlumnos = cantidadAlumnos;
		this.alumnos = new Alumno[cantidadAlumnos];
		this.promedioMinimo = promedioMinimo;
	}
	
	public int getCantidadAlumnos() {
		return cantidadAlumnos;
	}

	public void setCantidadAlumnos(int cantidadAlumnos) {
		this.cantidadAlumnos = cantidadAlumnos;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}
    
	
    
	public double getPromedioMinimo() {
		return promedioMinimo;
	}

	public void setPromedioMinimo(double promedioMinimo) {
		this.promedioMinimo = promedioMinimo;
	}

	// metodos para gestionar alumnos y notas
	public Double obtenerNotaMasAlta() {
		double max=-1;		
		
		for (Alumno alumno : alumnos) {
			for (Double nota : alumno.getNotas()) {
				if(nota>max) {
					max = nota;
				}
			}
		}
		return max;
	}
	
	public Double obtenerNotaMasBaja() {
		double min=11;		
		
		for (Alumno alumno : alumnos) {
			for (Double nota : alumno.getNotas()) {
				if(nota<min) {
					min = nota;
				}
			}
		}
		return min;
	}
	
	public List<Alumno> obtenerAlumnosCalificacionMasAlta(){
		double max= obtenerNotaMasAlta();
		List<Alumno> alumnosNotaMasAlta = new ArrayList<>();
		
		for (Alumno alumno : alumnos) {
			for (Double nota : alumno.getNotas()) {
				if(nota == max) {
					//agrego alumno si no esta en lista
					if(!alumnosNotaMasAlta.contains(alumno))
						alumnosNotaMasAlta.add(alumno);			
				}
			}
		}
		return alumnosNotaMasAlta;
	}
	
	public List<Alumno> obtenerAlumnosCalificacionMasBaja(){
		double min= obtenerNotaMasBaja();
		List<Alumno> alumnosNotaMasBaja = new ArrayList<>();
		
		for (Alumno alumno : alumnos) {
			for (Double nota : alumno.getNotas()) {
				if(nota == min) {
					//agrego alumno si no esta en lista
					if(!alumnosNotaMasBaja.contains(alumno))
						alumnosNotaMasBaja.add(alumno);			
				}
			}
		}
		return alumnosNotaMasBaja;
	}
	
	public List<Alumno> obtenerAlumnosPromocionan(){		
		List<Alumno> alumnosAprobados = new ArrayList<>();
		
		for (Alumno alumno : alumnos) {
			if(alumno.obtenerPromedio()>= promedioMinimo) {
				alumnosAprobados.add(alumno);
			}
		}
		return alumnosAprobados;
	}
	
	public List<Alumno> obtenerAlumnosRecursan(){
		List<Alumno> alumnosDesaprobados = new ArrayList<>();
		
		for (Alumno alumno : alumnos) {
			if(alumno.obtenerPromedio()< promedioMinimo) {
				alumnosDesaprobados.add(alumno);
			}
		}
		return alumnosDesaprobados;
	}

	public void cargarNotasAlumno(Scanner scanner, Double[] notas) {
		double nota;
		for(int j=0;j<3;j++){
			//vuelve a pedir nota si no es una nota valida entre 0 y 10		    		   
		    do {
		    	System.out.print("Nota "+(j+1)+" (entre 0 y 10):");            
			    nota = scanner.nextDouble();			    
			}while(nota<0 || nota>10);
		    notas[j] = nota;
		}
	}
	
	public void agregarAlumnos(Scanner scanner) {
		for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("\n\nIngrese los datos del "+ (i + 1)+"º alumno:");
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Apellido: ");
            String apellido = scanner.next();
            
            Double[] notas = new Double[3];                        
            cargarNotasAlumno(scanner, notas);
                                    
            Alumno alumno = new Alumno(nombre, apellido,notas);
            
            alumnos[i] = alumno;
        }
	}
}

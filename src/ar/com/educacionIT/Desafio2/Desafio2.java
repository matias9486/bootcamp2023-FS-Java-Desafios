package ar.com.educacionIT.Desafio2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Desafio2 {
		
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
	        System.out.print("Ingrese la cantidad de alumnos a procesar: ");
	        int cantidadAlumnos = scanner.nextInt();
	        
	        System.out.print("\nIngrese el promedio mínimo para promocionar: ");
	        double promedioMinimo = scanner.nextDouble();
	
	        ControlNotas controlNotas = new ControlNotas(cantidadAlumnos, promedioMinimo);
	        
	        controlNotas.agregarAlumnos(scanner);
	        
	        /*
	        for (Alumno alumno : controlNotas.getAlumnos()) {
				System.out.println(alumno);
			}*/
	                        
	        System.out.println("\nAlumnos con la nota Mas alta("+ controlNotas.obtenerNotaMasAlta() +"):");
	        for (Alumno alumno : controlNotas.obtenerAlumnosCalificacionMasAlta()) {
				System.out.println(alumno);
			}
	                
	        System.out.println("\nAlumnos con la nota Mas baja("+ controlNotas.obtenerNotaMasBaja() + "):");
	        for (Alumno alumno : controlNotas.obtenerAlumnosCalificacionMasBaja()) {
				System.out.println(alumno);
			}
	                
	        System.out.println("\nAlumnos que promocionan:");
	        for (Alumno alumno : controlNotas.obtenerAlumnosPromocionan()) {
				System.out.println(alumno);
			}
	                
	        System.out.println("\nAlumnos que recursan:");
	        for (Alumno alumno : controlNotas.obtenerAlumnosRecursan()) {
				System.out.println(alumno);
			}
	        
	        scanner.close();
		}
		catch(InputMismatchException e) {
			System.err.println("Se ha producido un error. ");
			e.printStackTrace();
		}
		catch(Exception e) {
			System.err.println("Se ha producido un error. ");
			e.printStackTrace();
		}
	}

}


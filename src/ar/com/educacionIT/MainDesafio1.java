package ar.com.educacionIT;

import java.util.Scanner;

public class MainDesafio1 {
	public static int pedirValorEntero(Scanner teclado, String mensaje) {
		int valorEntero;				
				        
        System.out.println(mensaje);
        valorEntero = teclado.nextInt();				
        return valorEntero;							
	}
		
	public static boolean validarMes(int mes) {
		return (mes>=1 && mes<=12);
	}	
	
	public static boolean validarAnio(int anio) {
		return (anio>=1900 && anio<=2099);
	}
	
	public static boolean validarAnioBisiesto(int anio) {
		return ((anio % 4 == 0) && (anio % 100 != 0) || (anio % 400 == 0));
	}	
	
	public static boolean validarDia(int dia, int mes, int anio) {
		boolean diaValido;
		if (dia<1 || dia >31)
			return false;
		
		switch (mes) {
			case 2:			
				if(validarAnioBisiesto(anio)) {
					diaValido = (dia<=29);
				}else {
					diaValido = (dia<=28);
				}				
				break;			
			case 1, 3, 5, 7, 8, 10, 12:			
				diaValido = (dia<=31);				
				break;
			case 4, 6, 9, 11:
				diaValido = (dia<=30);
				break;		
			default:
				diaValido = false;
				break;
		}
		return diaValido;
	}
	
	public static boolean validarFecha(int dia, int mes, int anio) {			
		//return (validarMes(mes) && validarAnio(anio) && validarDia(dia, mes, anio));
		if(!validarMes(mes))
			return false;
		
		if(!validarAnio(anio))
			return false;
		
		return validarDia(dia,mes,anio);
	}
	
	public static void main(String[] args) {
		int dia, mes, anio;
		Scanner teclado = new Scanner(System.in);
			
		dia = pedirValorEntero(teclado, "Ingrese dia:");
		mes = pedirValorEntero(teclado, "Ingrese mes:");
		anio = pedirValorEntero(teclado, "Ingrese año:");
		teclado.close();
		
		//Para ver por consola si los datos son correctos. No hace falta porque validarFecha los usa internamente
		System.out.println("\nMes valido?: " + (validarMes(mes)?"Si":"No"));
		System.out.println("Año valido?: " + (validarAnio(anio)?"Si":"No"));
		System.out.println("Dia Valido?: " + (validarDia(dia, mes, anio)?"Si":"No"));
		
		System.out.println("\n"+dia+"-"+mes+"-"+anio+" es una Fecha Valida? " + (validarFecha(dia, mes, anio)?"Si":"No"));
	}
}

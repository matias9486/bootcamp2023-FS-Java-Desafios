package ar.com.educacionIT.Desafio3;

public class VoladorAceptado extends Volador implements IVoladorAceptado{

	public VoladorAceptado(String empresa, String origen) {
		super(empresa, origen); 
	}

	@Override
	public void aterrizar() {
		System.out.println("\n"+super.toString()+ "Aterriza por pista 1.");
	}

	@Override
	public boolean cumplirContrato() {		
		return true;
	}

}

package ar.com.educacionIT.Desafio3;

public class VoladorRechazado extends Volador implements IVoladorRechazado{

	public VoladorRechazado(String empresa, String origen) {
		super(empresa, origen); 
	}

	@Override
	public boolean cumplirContrato() {		
		return false;
	}

	@Override
	public void pedirAutorizacion(boolean autorizacion) {
		if(autorizacion){
			System.out.println(super.toString()+ ". Aterriza por pista 2.");
		}else {
			System.out.println(super.toString()+ ". No puede aterrizar");
		}
	}

}

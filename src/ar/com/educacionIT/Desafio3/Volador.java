package ar.com.educacionIT.Desafio3;

public abstract class Volador implements IVolador {
	private String empresa;
	private String origen;
	public Volador(String empresa, String origen) {
		super();
		this.empresa = empresa;
		this.origen = origen;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	@Override
	public String toString() {
		return "Volador [empresa=" + empresa + ", origen=" + origen + "]";
	}	
}

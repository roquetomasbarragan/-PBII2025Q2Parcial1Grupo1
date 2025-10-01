package ar.edu.unlam.dominio;

public abstract class Cancha {

	
	private Double precioBasePorHora;

	public Cancha( Double precioBasePorHora) {
		
		this.precioBasePorHora = precioBasePorHora;
	}
	
	public abstract Integer getCapacidadMax();

	public Double getPrecioBasePorHora() {
		return precioBasePorHora;
	}

	

	
	
}

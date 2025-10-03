package ar.edu.unlam.dominio;

public abstract class CanchaDeFutbol extends Cancha {

	public CanchaDeFutbol(Double precioBasePorHora) {
		super(precioBasePorHora);
	}

	@Override
	public abstract Integer getCapacidadMax();
		
	

}

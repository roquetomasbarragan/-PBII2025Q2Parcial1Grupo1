package ar.edu.unlam.dominio;

public class CanchaDeTenis extends Cancha{
	
	private final Integer capacidadMax = 2; 

	public CanchaDeTenis(Double precioBasePorHora) {
		super(precioBasePorHora);
	}

	@Override
	public Integer getCapacidadMax() {
		return this.capacidadMax;
	}

}

package ar.edu.unlam.dominio;

public class CanchaDeTenis extends Cancha {

	public final Integer CAPACIDAD_MAX = 4;
	public CanchaDeTenis(Double precioBasePorHora, Integer idCancha) {
		super(precioBasePorHora, idCancha);
		
	}

	@Override
	public Integer getCapacidadMax() {
		
		return this.CAPACIDAD_MAX;
	}

}

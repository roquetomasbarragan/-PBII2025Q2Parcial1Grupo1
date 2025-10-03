package ar.edu.unlam.dominio;

public abstract class CanchaDeFutbol extends Cancha {

	public CanchaDeFutbol(Double precioBasePorHora, Integer idCancha) {
		super(precioBasePorHora, idCancha);
		// TODO Auto-generated constructor stub
	}

	@Override
	public abstract Integer getCapacidadMax();
		
	

}

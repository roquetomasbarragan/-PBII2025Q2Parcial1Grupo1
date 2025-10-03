package ar.edu.unlam.dominio;

public class CanchaDeFutbol5 extends CanchaDeFutbol {

	private final Integer CAPACIDAD_MAX = 10;
	
	public CanchaDeFutbol5( Double precioBase, Integer idCancha) {
		super( precioBase, idCancha);
		
	}

	@Override
	public Integer getCapacidadMax() {
		return this.CAPACIDAD_MAX;
	}
	
}

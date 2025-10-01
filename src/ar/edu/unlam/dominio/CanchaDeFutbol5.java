package ar.edu.unlam.dominio;

public class CanchaDeFutbol5 extends Cancha {

	private static final Integer CapacidadMax = 10;
	
	public CanchaDeFutbol5( Double precioBase, Integer idCancha) {
		super( precioBase, idCancha);
		
	}

	@Override
	public Integer getCapacidadMax() {
		return this.CapacidadMax;
	}
	
}

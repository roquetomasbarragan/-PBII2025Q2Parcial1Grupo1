package ar.edu.unlam.dominio;

public class CanchaDeFutbol7  extends CanchaDeFutbol {
	
	private final Integer capacidadMax = 14;
	
	public CanchaDeFutbol7 (Double precioBase) {
		super(precioBase);
		
	}

	@Override
	public Integer getCapacidadMax() {
		return this.capacidadMax;
	}
	
}

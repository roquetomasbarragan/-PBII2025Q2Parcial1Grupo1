package ar.edu.unlam.dominio;

public class CanchaDeFutbol11 extends CanchaDeFutbol {

	private final Integer capacidadMax = 22;
	
	public CanchaDeFutbol11(Double precioBase) {
		super(precioBase);
	}

	@Override
	public Integer getCapacidadMax() {
		return this.capacidadMax;
	}
	
}

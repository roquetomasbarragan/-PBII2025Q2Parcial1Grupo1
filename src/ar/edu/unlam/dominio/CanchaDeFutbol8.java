package ar.edu.unlam.dominio;

public class CanchaDeFutbol8 extends CanchaDeFutbol {

	private final Integer capacidadMax = 16;
	
	public CanchaDeFutbol8(Double precioBase) {
		super(precioBase);
		this.tipoDeCancha = "cancha de futbol 8";
	}

	@Override
	public Integer getCapacidadMax() {
		return this.capacidadMax;
	}
	
}

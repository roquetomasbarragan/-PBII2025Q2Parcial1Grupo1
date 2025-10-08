package ar.edu.unlam.dominio;

public class CanchaDeFutbol5 extends CanchaDeFutbol {

	private final Integer capacidadMax = 10;
	
	public CanchaDeFutbol5 (Double precioBase) {
		super(precioBase);
		this.tipoDeCancha = "cancha de futbol 5";
	}

	@Override
	public Integer getCapacidadMax() {
		return this.capacidadMax;
	}
	
}
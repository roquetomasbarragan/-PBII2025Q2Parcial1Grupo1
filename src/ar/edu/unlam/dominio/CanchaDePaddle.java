package ar.edu.unlam.dominio;

public class CanchaDePaddle extends Cancha {
	
	private final Integer capacidadMax = 4;

	public CanchaDePaddle(Double precioBasePorHora) {
		super(precioBasePorHora);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Integer getCapacidadMax() {
		return this.capacidadMax;
	}

}

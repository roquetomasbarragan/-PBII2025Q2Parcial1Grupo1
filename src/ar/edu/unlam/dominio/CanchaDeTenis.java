package ar.edu.unlam.dominio;


public class CanchaDeTenis extends Cancha {

	public final Integer capacidadMax = 4;
	
	public CanchaDeTenis(Double precioBasePorHora) {
		super(precioBasePorHora);
		this.tipoDeCancha = "cancha de tenis"; 
	}

	@Override
	public Integer getCapacidadMax() {
		
		return this.capacidadMax;
	}

}

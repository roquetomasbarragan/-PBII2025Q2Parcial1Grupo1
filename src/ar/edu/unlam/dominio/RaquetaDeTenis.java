package ar.edu.unlam.dominio;

public class RaquetaDeTenis extends ItemAdicional {
	
	public RaquetaDeTenis() {
		super();
		setCosto(7000.0);
	}

	@Override
	public Double calcularCosto(Cancha cancha) {
		return getCosto() * cancha.getCapacidadMax();
	}

	@Override
	public Boolean esCompatibleConLaCancha(Cancha cancha) {
		Boolean esCompatible = false;
		if (cancha instanceof CanchaDeTenis) {
			esCompatible = true;
		}
		return esCompatible;
	}


	


}

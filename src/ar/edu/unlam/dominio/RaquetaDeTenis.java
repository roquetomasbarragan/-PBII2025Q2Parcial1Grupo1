package ar.edu.unlam.dominio;

public class RaquetaDeTenis implements ItemAdicional {
	private Double costo = 7000.0;

	@Override
	public Double calcularCosto() {
		return this.costo;
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

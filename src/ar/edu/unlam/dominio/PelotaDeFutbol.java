package ar.edu.unlam.dominio;

public class PelotaDeFutbol extends ItemAdicional {

	
	public PelotaDeFutbol() {
		super();
		setCosto(5000.00);
	}

	@Override
	public Double calcularCosto(Cancha cancha) {
		return getCosto();
	}

	@Override
	public Boolean esCompatibleConLaCancha(Cancha cancha) {
		if(cancha instanceof CanchaDeFutbol) {
			return true;
		}
		return false;
	}


}
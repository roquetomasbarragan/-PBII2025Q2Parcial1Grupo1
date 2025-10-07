package ar.edu.unlam.dominio;

public class PelotaDeFutbol implements ItemAdicional {

	private final Double precioPelota = 5000.00;
	
	@Override
	public Double calcularCosto(Cancha cancha) {
		return this.precioPelota;
	}

	@Override
	public Boolean esCompatibleConLaCancha(Cancha cancha) {
		if(cancha instanceof CanchaDeFutbol) {
			return true;
		}
		return false;
	}

}
package ar.edu.unlam.dominio;

public abstract class ItemAdicional {
	
	private Double costo;
	

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costoDelItem) {
		this.costo = costoDelItem;
	}

	public abstract Double calcularCosto(Cancha cancha);
	
	public abstract Boolean esCompatibleConLaCancha(Cancha cancha);


	
}

package ar.edu.unlam.dominio;

public interface ItemAdicional {
	
	public abstract Double calcularCosto(Cancha cancha);
	
	public abstract Boolean esCompatibleConLaCancha(Cancha cancha);


	
}

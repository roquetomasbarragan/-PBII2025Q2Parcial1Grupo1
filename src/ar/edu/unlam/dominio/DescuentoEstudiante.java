package ar.edu.unlam.dominio;

public class DescuentoEstudiante implements ItemAdicional {

	private final Double porcentajeDescuento = 0.10; // 10%
	
	@Override
	public Double calcularCosto(Cancha cancha) {
		// Retorna un valor negativo porque es un descuento
		return -(cancha.getPrecioBasePorHora() * porcentajeDescuento);
	}

	@Override
	public Boolean esCompatibleConLaCancha(Cancha cancha) {
		// El descuento es compatible con cualquier tipo de cancha
		return true;
	}

}
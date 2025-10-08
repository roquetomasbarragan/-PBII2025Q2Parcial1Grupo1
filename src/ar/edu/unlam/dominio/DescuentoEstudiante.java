package ar.edu.unlam.dominio;

public class DescuentoEstudiante implements Tarifable  {
	
	private ReservaBase reservaBase;
	private final Double porcentajeDescuento = 0.10;
	
	public DescuentoEstudiante(ReservaBase reservaBase) {
		this.reservaBase = reservaBase;
	}

	@Override 
	public Double calcularPrecioFinal() {
		Double precioSinDescuento = reservaBase.calcularPrecioFinal();
		Double descuento = precioSinDescuento * porcentajeDescuento;
		return precioSinDescuento - descuento;
	}

	}

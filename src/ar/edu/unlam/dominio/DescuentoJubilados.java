package ar.edu.unlam.dominio;

public class DescuentoJubilados implements Tarifable  {
	
	private ReservaBase reservaBase;
	private final Double porcentajeDescuento = 0.15;
	
	public DescuentoJubilados(ReservaBase reservaBase) {
		this.reservaBase = reservaBase;
	}

	@Override 
	public Double calcularPrecioFinal() {
		Double precioSinDescuento = reservaBase.calcularPrecioFinal();
		Double descuento = precioSinDescuento * porcentajeDescuento;
		return precioSinDescuento - descuento;
	}

	}


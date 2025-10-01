package ar.edu.unlam.dominio;

import java.util.HashSet;

public class GestorDeReserva {

	private HashSet<Cancha> canchas;
	private HashSet<Reserva> reservas;
	
	public GestorDeReserva() {
		this.canchas = new HashSet<>();
		this.reservas = new HashSet<>();
	}
	
	
	public Boolean agregarCancha(Cancha cancha) {
		
		return this.canchas.add(cancha);
	}


	public Boolean agregarReserva(Reserva reserva) {
		return reservas.add(reserva);
	}

}
